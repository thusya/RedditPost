package com.thus.redditpost.data.repository

import com.thus.redditpost.data.model.toPostsInfoList
import com.thus.redditpost.data.network.ApiService
import com.thus.redditpost.domain.PostsRepository
import com.thus.redditpost.domain.model.PostsInfo

class PostsRepositoryImpl(private val apiService: ApiService) : PostsRepository {

    override suspend fun getPosts(limit: Int, page: String): List<PostsInfo> {
        return apiService.getPosts(limit, page).toPostsInfoList()
    }

}