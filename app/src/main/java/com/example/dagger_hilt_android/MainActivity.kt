package com.example.dagger_hilt_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dagger_hilt_android.model.*
import com.example.dagger_hilt_android.utils.TAG

/**
 * MainActivity is the main screen of the application.
 * */
class MainActivity : AppCompatActivity() {
    private lateinit var mobile: Mobile

    /**
     * onCreate callback method of the Activity
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* This is an example of Manual constructor injection */
        /*
        * As it is clearly visible the job of MainActivity is to create an instance of
        * Battery, Processor and Mobile.
        * This is a bad practice as it is tightly coupled.
        * */
        val battery = Battery("5500 mAh Cobalt")
        val processor = Processor("Snapdragon 725")
        mobile = Mobile(battery, processor)
        mobile.print()
    }
}