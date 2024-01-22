package com.example.dagger_hilt_android.utils

import java.lang.IllegalArgumentException

class Helper {
    fun isPalindrome(input: String): Boolean {
        var i = 0;
        var j = input.length - 1
        var result = true
        while (i < j) {
            if (input[i] != input[j]) {
                result = false
                break
            }
            i++
            j--
        }
        return result;
    }

    fun validatePassword(input: String): String = when {
        input.isBlank() -> "Password is required"
        input.length < 6 -> "Password should be greater than 6 digit"
        input.length > 15 -> "Password should be smaller than 15 digit"
        else -> "Password is Valid"
    }

    fun reverseString(input: String?) : String {
        if (input == null) {
            throw IllegalArgumentException("Null String cannot be reversed!")
        } else {
            val inputArray = input.toCharArray()
            var i = 0;
            var j = input.length - 1
            while(i < j) {
                val temp = inputArray[i]
                inputArray[i] = inputArray[j]
                inputArray[j] = temp
                i++
                j--
            }
            return inputArray.concatToString()
        }
    }
}