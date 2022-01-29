package com.example.dagger_hilt_android.modules

import com.example.dagger_hilt_android.model.Processor
import com.example.dagger_hilt_android.model.Snapdragon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule
{
    @Provides
    @Singleton
    fun getProcessor(snapdragon : Snapdragon) : Processor = snapdragon

    @Provides
    @Named("core")
    fun getCore() : Int = 8

    @Provides
    @Named("clockSpeed")
    fun getClockSpeed() : Int = 12
}