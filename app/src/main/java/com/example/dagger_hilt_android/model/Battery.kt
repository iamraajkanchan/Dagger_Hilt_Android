package com.example.dagger_hilt_android.model

import com.example.dagger_hilt_android.di.MName
import com.example.dagger_hilt_android.utils.TAG
import javax.inject.Inject

/**
 * This is an example of Hilt Constructor Injection
 *
 * Warning: As the argument of [Battery]
 * @param name is used in Hilt System you cannot use private modifier
 * */
class Battery @Inject constructor(@MName val name: String) {
    fun printBatteryName() {
        println("$TAG :: Battery :: Battery Name: $name")
    }
}