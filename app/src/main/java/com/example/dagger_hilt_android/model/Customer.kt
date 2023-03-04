package com.example.dagger_hilt_android.model

import com.example.dagger_hilt_android.di.CName
import com.example.dagger_hilt_android.utils.TAG
import javax.inject.Inject

class Customer @Inject constructor(@CName val customerName: String, private val age: Int) {
    fun printCustomerDetails() {
        println("$TAG :: $customerName is $age old")
    }
}