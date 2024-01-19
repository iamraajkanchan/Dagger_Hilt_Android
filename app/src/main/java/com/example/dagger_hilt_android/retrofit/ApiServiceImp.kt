package com.example.dagger_hilt_android.retrofit

import javax.inject.Inject

class ApiServiceImp @Inject constructor(private val apiService: ApiService) {
    suspend fun getAlbums() = apiService.getAlbums()
}