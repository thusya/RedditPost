package com.thus.redditpost.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thus.redditpost.data.model.RedditPost

@Dao
interface RedditPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<RedditPost>)

    @Query("SELECT * FROM RedditPost")
    fun getPostsLocalSource(): PagingSource<Int, RedditPost>

    @Query("DELETE FROM RedditPost")
    suspend fun deleteAll()
}