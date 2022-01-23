package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils
import javax.inject.Inject

class Battery @Inject constructor()
{
    init
    {
        Log.d(Utils.TAG , "Battery :: $this")
    }
}