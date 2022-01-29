package com.example.dagger_hilt_android

import android.app.Application
import android.util.Log
import com.example.dagger_hilt_android.model.Camera
import com.example.dagger_hilt_android.model.Processor
import com.example.dagger_hilt_android.utils.Utils
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application()
{

    @Inject
    lateinit var processor1 : Processor

    @Inject
    lateinit var processor2 : Processor

    override fun onCreate()
    {
        super.onCreate()
        Log.d(Utils.TAG , "===============MainApplication==================")
        Log.d(Utils.TAG , "Processor 1: $processor1")
        Log.d(Utils.TAG , "Processor 2: $processor2")
    }

}