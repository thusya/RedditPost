package com.thus.redditpost.domain.repository

import androidx.paging.PagingData
import com.thus.redditpost.domain.model.PostsInfo
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getPostsPaging(): Flow<PagingData<PostsInfo>>
}