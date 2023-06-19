package com.thus.redditpost.data.model

import com.squareup.moshi.Json

data class Image(
    @field:Json(name = "id")
    val id: String? = null,

    @field:Json(name = "resolutions")
    val resolutions: List<Resolution>? = null,

    @field:Json(name = "source")
    val source: Source? = null,

    @field:Json(name = "variants")
    val variants: Variants? = null
)