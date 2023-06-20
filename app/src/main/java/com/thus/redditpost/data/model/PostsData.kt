package com.thus.redditpost.data.model

import com.squareup.moshi.Json

data class PostsData(
    @field:Json(name = "after")
    val after: String? = null,

    @field:Json(name = "dist")
    val dist: Int? = null,

    @field:Json(name = "modhash")
    val modhash: String? = null,

    @field:Json(name = "geo_filter")
    val geo_filter: Any? = null,

    @field:Json(name = "children")
    val children: List<Children>? = null,

    @field:Json(name = "before")
    val before: Any? = null
)