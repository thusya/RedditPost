package com.thus.redditpost.domain.model

data class PostsInfo(
    val linkFlairText: String = "",
    val title: String = "",
    val domain: String = "",
    val author: String = "",
    val thumbnail: String = "",
    val urlOverriddenByDest: String = "",
    val created: Double = 0.0,
    val ups: Int = 0,
    val numComments: Int = 0,
    val after: String = ""
)