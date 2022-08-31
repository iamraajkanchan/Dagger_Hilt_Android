package com.example.dagger_hilt_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    @BName
    fun provideBatteryName() = "Samsung Battery"

    @Provides
    @Singleton
    @PName
    fun provideProcessorName() = "SnapDragon 650"
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PName