package com.thus.redditpost.data.repository

import com.thus.redditpost.data.model.PostsResponse
import com.thus.redditpost.data.network.ApiService
import com.thus.redditpost.domain.PostsRepository

class PostsRepositoryImpl(private val apiService: ApiService) : PostsRepository {

    override suspend fun getPosts(limit: Int, page: String): PostsResponse {
        return apiService.getPosts(limit, page)
    }

}