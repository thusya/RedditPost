package com.thus.redditpost.di

import com.thus.redditpost.BuildConfig
import com.thus.redditpost.data.network.ApiService
import com.thus.redditpost.data.repository.PostsRepositoryImpl
import com.thus.redditpost.domain.PostsRepository
import com.thus.redditpost.ui.posts.PostsViewModel
import com.thus.redditpost.ui.util.WebUtil
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModules = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient())
            .build()
            .create(ApiService::class.java)
    }

    factory<PostsRepository> { PostsRepositoryImpl(get()) }
    single { WebUtil() }

    viewModel { PostsViewModel(get()) }
}