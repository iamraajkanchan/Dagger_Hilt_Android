package com.example.dagger_hilt_android.model

class Mobile
{
    private var battery : Battery ?= null
    private var processor : Processor ?= null

    init
    {
        battery = Battery()
        processor = Processor()
    }
}