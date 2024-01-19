package com.example.dagger_hilt_android.retrofit

import com.example.dagger_hilt_android.model.Album
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/albums")
    suspend fun getAlbums(): Flow<Response<List<Album>>>
}