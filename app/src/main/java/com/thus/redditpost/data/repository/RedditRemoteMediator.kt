package com.thus.redditpost.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.thus.redditpost.data.db.RedditDb
import com.thus.redditpost.data.model.RedditPost
import com.thus.redditpost.data.model.RedditRemoteKey
import com.thus.redditpost.data.model.toRedditPostList
import com.thus.redditpost.data.network.ApiService
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class RedditRemoteMediator(
    private val apiService: ApiService,
    private val redditDb: RedditDb
) : RemoteMediator<Int, RedditPost>() {

    private val redditPostDao = redditDb.getRedditPostDao()
    private val redditRemoteKeyDao = redditDb.getRedditRemoteKeyDao()

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, RedditPost>
    ): MediatorResult {
        try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val remoteKey = redditDb.withTransaction {
                        redditRemoteKeyDao.getRemoteKey()
                    }
                    remoteKey.nextPageKey ?: return MediatorResult.Success(endOfPaginationReached = true)
                }
            }

            val response = apiService.getPosts(
                after = loadKey,
                before = null,
                limit = when (loadType) {
                    LoadType.REFRESH -> state.config.initialLoadSize
                    else -> state.config.pageSize
                }
            )
            val redditPostList = response.toRedditPostList()

            redditDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    redditPostDao.deleteAll()
                    redditRemoteKeyDao.deleteAll()
                }

                redditRemoteKeyDao.insert(RedditRemoteKey(nextPageKey = response.postData?.after))
                redditPostDao.insertAll(redditPostList)
            }

            return MediatorResult.Success(endOfPaginationReached = redditPostList.isEmpty())
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }
}