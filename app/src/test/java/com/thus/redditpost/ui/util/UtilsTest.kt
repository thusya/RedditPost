package com.thus.redditpost.ui.util

import org.junit.Assert.assertEquals
import org.junit.Test

class UtilsTest {

@Test
fun `formatCount returns count as string when count is less than 1000`() {
    // Given
    val count = 500

    // When
    val formattedCount = Utils.formatCount(count)

    // Then
    assertEquals("500", formattedCount)
}

@Test
fun `formatCount returns formatted count with K suffix when count is between 1000 and 999999`() {
    // Given
    val count = 1500

    // When
    val formattedCount = Utils.formatCount(count)

    // Then
    assertEquals("1.5 K", formattedCount)
}

@Test
fun `formatCount returns formatted count with M suffix when count is 1000000 or greater`() {
    // Given
    val count = 2500000

    // When
    val formattedCount = Utils.formatCount(count)

    // Then
    assertEquals("2.5 M", formattedCount)
}
}