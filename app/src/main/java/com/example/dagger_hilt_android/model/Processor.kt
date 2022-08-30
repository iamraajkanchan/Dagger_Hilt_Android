package com.example.dagger_hilt_android.model

import com.example.dagger_hilt_android.utils.TAG

class Processor(private val name: String) {
    fun printProcessorName() {
        println("$TAG :: Processor :: Processor Name: $name")
    }
}