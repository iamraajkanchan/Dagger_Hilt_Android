package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils

class Cobalt
{
    /*If you don't own the class then you can't annotate the class with @Inject*/
    init
    {
        Log.d(Utils.TAG , "Cobalt :: $this")
    }
}