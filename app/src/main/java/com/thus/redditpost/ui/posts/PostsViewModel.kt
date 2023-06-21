package com.thus.redditpost.ui.posts

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thus.redditpost.domain.PostsRepository
import com.thus.redditpost.domain.model.PostsInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class PostsViewModel(private val postsRepository: PostsRepository) : ViewModel() {

    val postsState = mutableStateOf<PostsState>(PostsState.Loading)

    var postDetailSelected: PostsInfo? = null
    init {
        fetchPosts()
    }

    fun fetchPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = postsRepository.getPosts(20, "")

                postsState.value = PostsState.Normal(response)

            } catch (e: Exception) {
                Log.d("Error", e.message.toString())
                postsState.value = PostsState.Error(e)
            }

        }
    }
}

//PostsInfo(linkFlairText=TechSupport, title=Got a tech question or want to discuss tech? Bi-Weekly /r/Technology Tech Support / General Discussion Thread, domain=self.technology, author=veritanuda, thumbnail=self, urlOverriddenByDest=, created=1.685862202E9, ups=57, numComments=73, after=t3_14eazna)
//PostsInfo(linkFlairText=Energy, title=Texas power use to break records in heat wave, prices soar to $2,500 per megawatt hour - ERCOT, domain=reuters.com, author=geoxol, thumbnail=https://b.thumbs.redditmedia.com/G7L1PA5rcMbK1fK1cg36LcHMiHt69NlkUX-gY11SFTU.jpg, urlOverriddenByDest=https://www.reuters.com/world/us/texas-power-use-break-records-heat-wave-prices-soar-ercot-2023-06-20/, created=1.68727451E9, ups=1221, numComments=375, after=t3_14eazna)