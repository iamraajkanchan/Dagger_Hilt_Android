package com.example.dagger_hilt_android.retrofit

import com.example.dagger_hilt_android.model.PostItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi
{
    @GET("posts")
    suspend fun getPosts() : List<PostItem>
}