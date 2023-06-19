package com.thus.redditpost.domain

import com.thus.redditpost.data.model.PostsResponse

interface PostsRepository {
    suspend fun getPosts(
        limit: Int,
        page: String
    ): PostsResponse
}