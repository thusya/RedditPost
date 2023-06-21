package com.thus.redditpost.ui.util

object Utils {

    fun formatCount(counts: Int): String {
        return when {
            counts in 1_000..999999 -> {
                val decimalPart = (counts % 1_000) / 100
                val formattedCount = counts / 1_000
                "$formattedCount.$decimalPart K"
            }

            counts >= 1_000_000 -> {
                val decimalPart = (counts % 1_000_000) / 100_000
                val formattedCount = counts / 1_000_000
                "$formattedCount.$decimalPart M"
            }

            else -> counts.toString()
        }
    }
}