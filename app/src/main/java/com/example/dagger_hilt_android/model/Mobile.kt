package com.example.dagger_hilt_android.model

import com.example.dagger_hilt_android.di.MobileName
import javax.inject.Inject

/**
 * This is an example of Dagger Constructor Injection
 *
 * Note: As the parameters of [Mobile]: [Battery] [Processor] and [Customer] is not a part of Hilt System,
 * so we can use the access modifier 'private' in the constructor
 *
 * */

class Mobile @Inject constructor(
    @MobileName val mobileName: String,
    private val battery: Battery,
    private val processor: Processor,
    private val customer: Customer
) {

    fun print() {
        customer.printCustomerDetails()
        battery.printBatteryName()
        processor.printProcessorName()
    }

}