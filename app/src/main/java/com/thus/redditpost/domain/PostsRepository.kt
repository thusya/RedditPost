package com.thus.redditpost.domain

import com.thus.redditpost.domain.model.PostsInfo

interface PostsRepository {
    suspend fun getPosts(
        limit: Int,
        page: String
    ): List<PostsInfo>
}