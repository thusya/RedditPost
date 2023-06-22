package com.thus.redditpost.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thus.redditpost.data.model.RedditPost
import com.thus.redditpost.data.model.RedditRemoteKey

@Database(
    entities = [RedditPost::class, RedditRemoteKey::class],
    version = 1,
    exportSchema = false
)
abstract class RedditDb : RoomDatabase() {

    companion object {
        private const val DB_NAME = "reddit_db.db"
        fun create(context: Context): RedditDb =
            Room.databaseBuilder(context, RedditDb::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract fun getRedditPostDao(): RedditPostDao
    abstract fun getRedditRemoteKeyDao(): RedditRemoteKeyDao
}