package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils
import javax.inject.Inject

class Battery(private var cobalt : Cobalt , private var lithium : Lithium)
{
    init
    {
        Log.d(Utils.TAG , "Battery :: $this, Cobalt :: $cobalt, Lithium :: $lithium")
    }
}