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
    @BatteryName
    fun provideBatteryName() = "Samsung Battery"

    @Provides
    @Singleton
    @ProcessorName
    fun provideProcessorName() = "SnapDragon 650"

    @Provides
    @Singleton
    @CustomerName
    fun provideCustomerName() = "John Doe"

    @Provides
    @Singleton
    fun provideCustomerAge() = 4

    @Provides
    @Singleton
    @MobileName
    fun provideMobileName() = "OnePlus"

    @Provides
    @Singleton
    @RetailerName
    fun provideRetailerName() = "Corporation of China"
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BatteryName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ProcessorName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CustomerName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RetailerName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MobileName