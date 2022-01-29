package com.example.dagger_hilt_android.modules

import com.example.dagger_hilt_android.model.Camera
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule
{

    @Provides
    @FragmentScoped
    fun getCamera() = Camera()
}