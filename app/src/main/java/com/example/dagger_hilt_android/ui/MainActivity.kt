package com.example.dagger_hilt_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dagger_hilt_android.R
import com.example.dagger_hilt_android.model.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * [MainActivity] is the main screen of the application.
 * I have to annotate [MainActivity] with AndroidEntryPoint to add into the Hilt System
 *
 * Warning : Please do not use the modifier private on a variable
 * if you are going to use the variable in Hilt System
 *
 * */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mobile: Mobile

    @Inject
    lateinit var customer: Customer

    @Inject
    lateinit var retailer: Retailer

    /**
     * onCreate callback method of the Activity
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mobile.print()
        customer.printCustomerDetails()
        retailer.printRetailerDetails()
    }
}