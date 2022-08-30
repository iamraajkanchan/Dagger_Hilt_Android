package com.example.dagger_hilt_android.model

import com.example.dagger_hilt_android.utils.TAG

class Battery(private val name: String) {
    fun printBatteryName() {
        println("$TAG :: Battery :: Battery Name: $name")
    }
}