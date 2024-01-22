package com.example.dagger_hilt_android.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import java.lang.IllegalArgumentException

class HelperTest {
    private lateinit var helper: Helper

    @Before
    fun setUp() {
        // Arrange
        helper = Helper()
    }

    @After
    fun tearDown() {
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

    @Test
    fun testPassword_with_invalid_input_blank() {
        // Act
        val result = helper.validatePassword("")
        // Assert
        assertEquals("Password is required", result)
    }

    @Test
    fun testPassword_with_invalid_input_less_than_six() {
        // Act
        val result = helper.validatePassword("hello")
        // Assert
        assertEquals("Password should be greater than 6 digit", result)
    }

    @Test
    fun testPassword_with_invalid_input_greater_than_fifteen() {
        // Act
        val result = helper.validatePassword("hello_world_from_computer_science")
        // Assert
        assertEquals("Password should be smaller than 15 digit", result)
    }

    @Test
    fun testPassword_with_valid_input() {
        // Act
        val result = helper.validatePassword("HelloWorld")
        // Assert
        assertEquals("Password is Valid", result)
    }

    @Test
    fun testReverse_with_blank_string() {
        // Act
        val result = helper.reverseString("")
        // Assert
        assertEquals("", result)
    }

    @Test
    fun testReverse_with_single_string() {
        // Act
        val result = helper.reverseString("a")
        // Assert
        assertEquals("a", result)
    }

    @Test
    fun testReverse_with_valid_string() {
        // Act
        val result = helper.reverseString("hello")
        // Assert
        assertEquals("olleh", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testReverse_with_null_string() {
        helper.reverseString(null)
    }
}