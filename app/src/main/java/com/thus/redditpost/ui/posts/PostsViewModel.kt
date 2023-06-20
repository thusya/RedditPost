package com.thus.redditpost.ui.posts

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thus.redditpost.domain.PostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class PostsViewModel(private val postsRepository: PostsRepository): ViewModel() {

    val postsState = mutableStateOf<PostsState>(PostsState.Loading)

    init {
        fetchPosts()
    }

    fun fetchPosts(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = postsRepository.getPosts(20, "")

                postsState.value = PostsState.Normal(response)

            } catch (e: Exception) {
                postsState.value = PostsState.Error(e)
            }

        }
    }
}