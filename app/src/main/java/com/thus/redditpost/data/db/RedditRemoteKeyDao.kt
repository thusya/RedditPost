package com.thus.redditpost.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thus.redditpost.data.model.RedditRemoteKey

@Dao
interface RedditRemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(keys: RedditRemoteKey)

    @Query("SELECT * FROM reddit_remote_key")
    suspend fun getRemoteKey(): RedditRemoteKey

    @Query("DELETE FROM reddit_remote_key")
    suspend fun deleteAll()
}