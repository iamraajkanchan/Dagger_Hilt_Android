package com.example.dagger_hilt_android.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_hilt_android.model.Album
import com.example.dagger_hilt_android.retrofit.AlbumResponseState
import com.example.dagger_hilt_android.retrofit.ApiService
import com.example.dagger_hilt_android.room.AlbumDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiService: ApiService,
    private val albumDao: AlbumDao
) :
    ViewModel() {
    private val _albumState: MutableStateFlow<AlbumResponseState> =
        MutableStateFlow(AlbumResponseState.Loading)
    val albumState: StateFlow<AlbumResponseState> get() = _albumState

    init {
        getAlbums()
    }

    private fun getAlbums() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = apiService.getAlbums()
            if (response.isSuccessful) {
                albumDao.insertAlbumInDatabase(response.body() ?: emptyList())
                albumDao.getAlbumsFromDatabase().collectLatest { albums ->
                    _albumState.value = AlbumResponseState.Success(response.message(), albums)
                }
            } else {
                _albumState.value = AlbumResponseState.Failed(Exception("No Response Found"))
            }
        }
    }

    fun addAlbum(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            albumDao.insertSingleAlbumInDatabase(album)
        }
    }

    fun deleteAlbum(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            albumDao.deleteAlbum(album)
        }
    }
}