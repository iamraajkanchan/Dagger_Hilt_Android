package com.example.dagger_hilt_android.modules

import com.example.dagger_hilt_android.model.Battery
import com.example.dagger_hilt_android.model.Cobalt
import com.example.dagger_hilt_android.model.Lithium
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule
{
    @Provides
    fun getCobalt() : Cobalt = Cobalt()

    @Provides
    fun getLithium() : Lithium
    {
        val lithium = Lithium()
        lithium.start()
        return lithium
    }

    @Provides
    @ActivityScoped
    fun getBattery(cobalt : Cobalt , lithium : Lithium) : Battery = Battery(cobalt , lithium)

}