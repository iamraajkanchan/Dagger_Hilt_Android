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
    @MName
    fun provideMobileName() = "5500 mAh Samsung Battery"

    @Provides
    @Singleton
    @PName
    fun provideProcessorName() = "Snapdragon 750"
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PName