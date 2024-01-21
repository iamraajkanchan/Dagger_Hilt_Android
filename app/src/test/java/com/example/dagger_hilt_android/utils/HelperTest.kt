package com.example.dagger_hilt_android.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {
    private lateinit var helper: Helper

    @Before
    fun setUp() {
        // Arrange
        println("Before Every Test Case")
        helper = Helper()
    }

    @After
    fun tearDown() {
        println("After Every Test Case")
    }

    @Test
    fun isPalindrome_inputString_hello_false() {
        // Act
        val result = helper.isPalindrome("hello")
        // Assert
        assertEquals(false, result)
    }

    @Test
    fun isPalindrome_inputString_level_true() {
        // Act
        val result = helper.isPalindrome("level")
        // Assert
        assertEquals(true, result)
    }
}