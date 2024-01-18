package com.example.dagger_hilt_android.model

import com.example.dagger_hilt_android.di.CustomerName
import com.example.dagger_hilt_android.utils.TAG
import javax.inject.Inject

class Customer @Inject constructor(@CustomerName val customerName: String, private val age: Int) {
    fun printCustomerDetails() {
        println("$TAG :: $customerName is $age old")
    }
}