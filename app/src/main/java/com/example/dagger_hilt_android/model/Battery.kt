package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils

class Battery(private var cobalt : Cobalt , private var lithium : Lithium)
{
    /*If you don't own the class then you can't annotate the class with @Inject*/
    init
    {
        Log.d(Utils.TAG , "Battery :: $this, Cobalt :: $cobalt, Lithium :: $lithium")
    }
}