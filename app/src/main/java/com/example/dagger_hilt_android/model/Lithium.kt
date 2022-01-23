package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils
import javax.inject.Inject

class Lithium
{
    init
    {
        Log.d(Utils.TAG , "Lithium :: $this")
    }

    fun start()
    {
        Log.d(Utils.TAG , "Lithium :: start")
    }
}