package com.example.dagger_hilt_android.modules

import com.example.dagger_hilt_android.model.Processor
import com.example.dagger_hilt_android.model.Snapdragon
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object SnapdragonModule
{
    @Provides
    fun getProcessor(snapdragon : Snapdragon) : Processor = snapdragon

    @Provides
    @Named("core")
    fun getCore() = 8

    @Provides
    @Named("clockSpeed")
    fun getClockSpeed() = 12
}