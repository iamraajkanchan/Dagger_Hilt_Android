package com.example.dagger_hilt_android.modules

import com.example.dagger_hilt_android.model.Battery
import com.example.dagger_hilt_android.model.Cobalt
import com.example.dagger_hilt_android.model.Lithium
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BatteryModule
{
    @Provides
    fun getCobalt() : Cobalt
    {
        return Cobalt()
    }

    @Provides
    fun getLithium() : Lithium
    {
        val lithium = Lithium()
        lithium.start()
        return lithium
    }

    @Provides
    fun getBattery(cobalt : Cobalt , lithium : Lithium) : Battery
    {
        return Battery(cobalt , lithium)
    }

}