package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils
import javax.inject.Inject

class Cobalt
{
    /*If we don't own the class then we can't annotate the class with @Inject*/
    init
    {
        Log.d(Utils.TAG , "Cobalt :: $this")
    }
}