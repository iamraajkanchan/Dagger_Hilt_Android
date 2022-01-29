package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

class Snapdragon @Inject constructor(
    @Named("core") var core : Int , @Named("clockSpeed") var clockSpeed : Int
) : Processor
{
    init
    {
        Log.d(Utils.TAG , "Snapdragon :: $this, Core :: $core :: ClockSpeed :: $clockSpeed")
        start()
    }

    override fun start()
    {
        Log.d(Utils.TAG , "Snapdragon :: start()")
    }
}