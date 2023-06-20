package com.thus.redditpost.ui.posts

import com.thus.redditpost.data.model.PostsResponse

sealed class PostsState{
    object Loading : PostsState()
    object Empty : PostsState()
    data class Error(val e: Exception) : PostsState()
    data class Normal(val showInfo: PostsResponse) : PostsState()
}