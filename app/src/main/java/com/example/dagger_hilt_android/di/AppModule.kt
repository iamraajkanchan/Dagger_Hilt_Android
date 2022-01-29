package com.example.dagger_hilt_android.di

import com.example.dagger_hilt_android.model.PostItem
import com.example.dagger_hilt_android.retrofit.PostApi
import com.example.dagger_hilt_android.retrofit.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.annotation.Signed
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule
{
    @Provides
    @Singleton
    fun getBaseURL() : String = RetrofitHelper.BASE_URL

    @Provides
    @Singleton
    fun getRetrofit(baseURL : String) : Retrofit =
        Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun getPostRequest(retrofit : Retrofit) : PostApi = retrofit.create(PostApi::class.java)
}