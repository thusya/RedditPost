package com.thus.redditpost.ui.posts

import com.thus.redditpost.domain.model.PostsInfo

sealed class PostsState {
    object Loading : PostsState()
    object Empty : PostsState()
    data class Error(val e: Exception) : PostsState()
    data class Normal(val showInfoList: List<PostsInfo>) : PostsState()
}