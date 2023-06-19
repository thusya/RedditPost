package com.thus.redditpost.data.network

import com.thus.redditpost.data.model.PostsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("r/technology/hot.json")
    suspend fun getPosts(
        @Query("limit") limit: Int,
        @Query("page") page: String
    ): PostsResponse
}