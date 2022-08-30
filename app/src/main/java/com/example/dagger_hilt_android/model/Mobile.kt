package com.example.dagger_hilt_android.model

import javax.inject.Inject

/**
 * This is an example of Dagger Constructor Injection
 *
 * Note: As both the parameters of [Mobile], [Battery] and [Processor] is not a part of Hilt System,
 * we can use the modifier private
 *
 * */

class Mobile @Inject constructor(private val battery: Battery, private val processor: Processor) {

    fun print() {
        battery.printBatteryName()
        processor.printProcessorName()
    }
}