package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils

class Battery(val cobalt : Cobalt , val lithium : Lithium)
{
    // If you do not own this class then you can't annotate this class with @Inject
    init
    {
        Log.d(Utils.TAG , "Battery :: $this")
    }
}