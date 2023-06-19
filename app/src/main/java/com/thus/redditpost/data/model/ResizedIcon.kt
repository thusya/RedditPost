package com.thus.redditpost.data.model

import com.squareup.moshi.Json

data class ResizedIcon(

    @field:Json(name = "height")
    val height: Int? = null,

    @field:Json(name = "url")
    val url: String? = null,

    @field:Json(name = "width")
    val width: Int? = null
)