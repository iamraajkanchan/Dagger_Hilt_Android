package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils
import javax.inject.Inject

class Lithium
{
    /*If we don't own the class then we can't annotate the class with @Inject*/
    init
    {
        Log.d(Utils.TAG , "Lithium :: $this")
    }

    fun start()
    {
        Log.d(Utils.TAG , "Lithium :: start()")
    }
}