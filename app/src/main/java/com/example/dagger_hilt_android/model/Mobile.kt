package com.example.dagger_hilt_android.model

import android.util.Log
import com.example.dagger_hilt_android.utils.Utils
import javax.inject.Inject

class Mobile @Inject constructor(var battery : Battery , var processor : Processor)
{
    init
    {
        Log.d(Utils.TAG , "Mobile :: $this, Battery :: $battery, Processor :: $processor")
    }
}