package com.thus.redditpost.ui.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.thus.redditpost.domain.repository.PostsRepository
import com.thus.redditpost.domain.model.PostsInfo

class PostsViewModel(postsRepository: PostsRepository) : ViewModel() {

    var postDetailSelected: PostsInfo? = null

    val posts = postsRepository.getPostsPaging()
        .cachedIn(viewModelScope)
}