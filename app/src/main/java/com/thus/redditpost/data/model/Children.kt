package com.thus.redditpost.data.model

import com.squareup.moshi.Json

data class Children(
        @field:Json(name = "kind")
        val kind: String? = null,

        @field:Json(name = "data")
        val childrenData: List<ChildrenData>? = null
)