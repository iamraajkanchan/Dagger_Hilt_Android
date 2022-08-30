package com.example.dagger_hilt_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dagger_hilt_android.model.*
import com.example.dagger_hilt_android.utils.TAG

/**
 * MainActivity is the main screen of the application.
 * */
class MainActivity : AppCompatActivity()
{
    private lateinit var mobile : Mobile

    /**
     * onCreate callback method of the Activity
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mobile = Mobile()
        Log.d(TAG, "onCreate: ")
    }
}