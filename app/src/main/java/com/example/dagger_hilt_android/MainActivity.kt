package com.example.dagger_hilt_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dagger_hilt_android.model.*
import com.example.dagger_hilt_android.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity()
{
    @Inject
    lateinit var samsung : Mobile

    @Inject
    lateinit var apple : Mobile
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(Utils.TAG , "Mobile : $samsung")
        Log.d(Utils.TAG , "Mobile : $apple  ")
    }
}