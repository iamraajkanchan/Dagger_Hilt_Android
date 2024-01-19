package com.example.dagger_hilt_android.retrofit

import com.example.dagger_hilt_android.model.Album

sealed class AlbumResponseState {
    object Loading : AlbumResponseState()
    class Success(val message: String, val albums: List<Album>) : AlbumResponseState()
    class Failed(val error: Throwable) : AlbumResponseState()
}
