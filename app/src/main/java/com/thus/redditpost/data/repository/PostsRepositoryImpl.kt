package com.thus.redditpost.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.thus.redditpost.data.db.RedditDb
import com.thus.redditpost.data.model.toPostsInfo
import com.thus.redditpost.domain.repository.PostsRepository
import com.thus.redditpost.domain.model.PostsInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PostsRepositoryImpl(
    private val db: RedditDb,
    private val redditRemoteMediator: RedditRemoteMediator
) : PostsRepository {

    companion object {
        private const val INIT_PAGE_SIZE = 20
        private const val PAGE_SIZE = 20
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getPostsPaging(): Flow<PagingData<PostsInfo>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = INIT_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = redditRemoteMediator
        ) {
            db.getRedditPostDao().getPostsFromLocalSource()
        }.flow.map { paging -> paging.map { it.toPostsInfo() } }
    }
}