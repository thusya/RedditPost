package com.thus.redditpost.ui.util

import java.text.SimpleDateFormat
import java.util.*
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.concurrent.TimeUnit

class DateTimeUtilsTest {

    @Test
    fun `getRelativeTime returns #now when duration is 0`() {
        // Given
        val durationSeconds = TimeUnit.MILLISECONDS.toSeconds(Date().time) - 0L

        // When
        val relativeTime = DateTimeUtils.getRelativeTime(durationSeconds)

        // Then
        assertEquals("now", relativeTime)
    }

    @Test
    fun `getRelativeTime returns correct relative time when duration is less than 60 seconds`() {
        // Given
        val durationSeconds = TimeUnit.MILLISECONDS.toSeconds(Date().time) - 30L

        // When
        val relativeTime = DateTimeUtils.getRelativeTime(durationSeconds)

        // Then
        assertEquals("30 seconds ago", relativeTime)
    }

    @Test
    fun `getRelativeTime returns #1 minute ago when duration is between 60 and 119 seconds`() {
        // Given
        val durationSeconds = TimeUnit.MILLISECONDS.toSeconds(Date().time) - 90L

        // When
        val relativeTime = DateTimeUtils.getRelativeTime(durationSeconds)

        // Then
        assertEquals("1 minute ago", relativeTime)
    }

    @Test
    fun `getRelativeTime returns correct relative time when duration is between 120 seconds and 1 hour`() {
        // Given
        val durationSeconds = TimeUnit.MILLISECONDS.toSeconds(Date().time) - 1500L

        // When
        val relativeTime = DateTimeUtils.getRelativeTime(durationSeconds)

        // Then
        assertEquals("25 minutes ago", relativeTime)
    }

    @Test
    fun `getRelativeTime returns #1 hour ago# when duration is between 1 hour and 1 hour 59 minutes`() {
        // Given
        val durationSeconds =
            TimeUnit.MILLISECONDS.toSeconds(Date().time) - TimeUnit.HOURS.toSeconds(1) - TimeUnit.MINUTES.toSeconds(
                30
            )

        // When
        val relativeTime = DateTimeUtils.getRelativeTime(durationSeconds)

        // Then
        assertEquals("1 hour ago", relativeTime)
    }

    @Test
    fun `getRelativeTime returns correct relative time when duration is between 2 hours and 24 hours`() {
        // Given
        val durationSeconds =
            TimeUnit.MILLISECONDS.toSeconds(Date().time) - TimeUnit.HOURS.toSeconds(3) - TimeUnit.MINUTES.toSeconds(
                45
            )

        // When
        val relativeTime = DateTimeUtils.getRelativeTime(durationSeconds)

        // Then
        assertEquals("3 hours ago", relativeTime)
    }

    @Test
    fun `getRelativeTime returns #1 day ago# when duration is between 24 hours and 47 hours`() {
        // Given
        val durationSeconds =
            TimeUnit.MILLISECONDS.toSeconds(Date().time) - TimeUnit.DAYS.toSeconds(1) - TimeUnit.HOURS.toSeconds(
                12
            )

        // When
        val relativeTime = DateTimeUtils.getRelativeTime(durationSeconds)

        // Then
        assertEquals("1 day ago", relativeTime)
    }

    @Test
    fun `getRelativeTime returns correct relative time when duration is between 2 days and 31 days`() {
        // Given
        val durationSeconds =
            TimeUnit.MILLISECONDS.toSeconds(Date().time) - TimeUnit.DAYS.toSeconds(10) - TimeUnit.HOURS.toSeconds(
                5
            )

        // When
        val relativeTime = DateTimeUtils.getRelativeTime(durationSeconds)

        // Then
        assertEquals("10 days ago", relativeTime)
    }

    @Test
    fun `getRelativeTime returns formatted date when duration is greater than 31 days`() {
        // Given
        val durationMillis = Date().time - TimeUnit.DAYS.toMillis(35)
        val durationSeconds = TimeUnit.MILLISECONDS.toSeconds(durationMillis)

        // When
        val relativeTime = DateTimeUtils.getRelativeTime(durationSeconds)

        // Then
        val expectedDate =
            SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(durationMillis)
        assertEquals(expectedDate, relativeTime)
    }
}