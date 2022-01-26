package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils
import javax.inject.Inject

class Snapdragon @Inject constructor() : Processor
{

    init
    {
        Log.d(Utils.TAG , "Snapdragon :: $this")
        start()
    }

    override fun start()
    {
        Log.d(Utils.TAG , "Snapdragon :: start()")
    }
}