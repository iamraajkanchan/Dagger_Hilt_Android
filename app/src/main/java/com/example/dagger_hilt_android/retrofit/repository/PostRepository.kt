package com.example.dagger_hilt_android.retrofit.repository

import com.example.dagger_hilt_android.model.PostItem
import com.example.dagger_hilt_android.retrofit.PostApi
import javax.inject.Inject

class PostRepository @Inject constructor(val postApi : PostApi)
{
    suspend fun getPost() = postApi.getPosts()
}