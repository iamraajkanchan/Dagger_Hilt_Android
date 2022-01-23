package com.example.dagger_hilt_android.modules

import com.example.dagger_hilt_android.model.Processor
import com.example.dagger_hilt_android.model.Snapdragon
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SnapdragonModule
{
    @Binds
    abstract fun getProcessor(snapdragon : Snapdragon) : Processor
}