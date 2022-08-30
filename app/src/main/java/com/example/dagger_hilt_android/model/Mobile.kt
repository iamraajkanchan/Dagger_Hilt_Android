package com.example.dagger_hilt_android.model

/* This is an example of Manual constructor injection. */
class Mobile(private val battery: Battery, private val processor: Processor) {

    fun print() {
        battery.printBatteryName()
        processor.printProcessorName()
    }
}