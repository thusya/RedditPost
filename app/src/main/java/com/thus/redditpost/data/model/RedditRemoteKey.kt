package com.thus.redditpost.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reddit_remote_key")
data class RedditRemoteKey(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nextPageKey: String?
)