package com.thus.redditpost.data.model

import com.squareup.moshi.Json

data class Preview(
    @field:Json(name = "enabled")
    val enabled: Boolean? = null,

    @field:Json(name = "images")
    val images: List<Image>? = null
)