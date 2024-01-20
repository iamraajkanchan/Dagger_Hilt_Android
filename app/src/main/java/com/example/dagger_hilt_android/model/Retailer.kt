package com.example.dagger_hilt_android.model

import com.example.dagger_hilt_android.di.CustomerName
import com.example.dagger_hilt_android.di.MobileName
import com.example.dagger_hilt_android.di.RetailerName
import com.example.dagger_hilt_android.utils.TAG
import javax.inject.Inject

class Retailer @Inject constructor(
    @RetailerName val retailerName: String,
    private val mobile: Mobile,
    private val customer: Customer
) {
    /*
    Note: You must use the annotation @Inject even if you
    have created your own custom @Qualifier
    */

    @Inject
    @MobileName
    lateinit var mobileName: String

    @Inject
    @CustomerName
    lateinit var customerName: String
    fun printRetailerDetails() {
        println("$TAG :: $retailerName sold $mobileName to $customerName")
    }
}