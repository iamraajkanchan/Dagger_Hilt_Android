package com.example.dagger_hilt_android.model

import com.example.dagger_hilt_android.di.PName
import com.example.dagger_hilt_android.utils.TAG
import javax.inject.Inject

/**
 * This is an example of Hilt Constructor Injection
 *
 * Warning: As the argument of [Processor]
 * @param name is used in Hilt system you cannot use private modifier.
 *
 * */
class Processor @Inject constructor(@PName val name: String) {
    fun printProcessorName() {
        println("$TAG :: Processor :: Processor Name: $name")
    }
}