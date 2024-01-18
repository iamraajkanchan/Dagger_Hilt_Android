package com.example.dagger_hilt_android.model

import com.example.dagger_hilt_android.di.AppModule
import com.example.dagger_hilt_android.di.RetailerName
import com.example.dagger_hilt_android.utils.TAG
import javax.inject.Inject

class Retailer @Inject constructor(
    @RetailerName val retailerName: String,
    private val mobile: Mobile,
    private val customer: Customer
) {
    fun printRetailerDetails() {
        println("$TAG :: $retailerName sold ${AppModule.provideMobileName()} to ${AppModule.provideCustomerName()}")
    }
}