package com.thus.redditpost.ui.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

object DateTimeUtils {

    fun getRelativeTime(durationSeconds: Long): String {
        val now = Date().time
        val durationMillis = TimeUnit.SECONDS.toMillis(durationSeconds)

        val differenceMillis = now - durationMillis
        val differenceSeconds = TimeUnit.MILLISECONDS.toSeconds(differenceMillis)

        return when {
            differenceSeconds <= 0 -> "now"
            differenceSeconds < 60 -> "$differenceSeconds seconds ago"
            differenceSeconds < 119 -> "1 minute ago"
            differenceSeconds < 3600 -> "${TimeUnit.SECONDS.toMinutes(differenceSeconds)} minutes ago"
            differenceSeconds < 7199 -> "1 hour ago"
            differenceSeconds < 86400 -> "${TimeUnit.SECONDS.toHours(differenceSeconds)} hours ago"
            differenceSeconds < 172799 -> "1 day ago"
            differenceSeconds < 2678400 -> "${TimeUnit.SECONDS.toDays(differenceSeconds)} days ago"
            else -> SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(durationMillis))
        }

    }

}