package com.thus.redditpost.di

import com.thus.redditpost.BuildConfig
import com.thus.redditpost.data.db.RedditDb
import com.thus.redditpost.data.network.ApiService
import com.thus.redditpost.data.repository.PostsRepositoryImpl
import com.thus.redditpost.data.repository.RedditRemoteMediator
import com.thus.redditpost.domain.repository.PostsRepository
import com.thus.redditpost.ui.posts.PostsViewModel
import com.thus.redditpost.ui.util.WebUtil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModules = module {

    single {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        )

        OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(get())
            .build()
            .create(ApiService::class.java)
    }

    factory<PostsRepository> { PostsRepositoryImpl(get(), get()) }
    factory { RedditRemoteMediator(get(), get()) }

    single { WebUtil() }

    viewModel { PostsViewModel(get()) }

    single {
        RedditDb.create(androidContext())
    }

}