package com.example.dagger_hilt_android.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_hilt_android.retrofit.AlbumResponseState
import com.example.dagger_hilt_android.retrofit.ApiServiceImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiServiceImp: ApiServiceImp) :
    ViewModel() {
    private val _albumState: MutableStateFlow<AlbumResponseState> =
        MutableStateFlow(AlbumResponseState.Loading)
    val albumState: StateFlow<AlbumResponseState> get() = _albumState

    fun getAlbums() {
        viewModelScope.launch {
            apiServiceImp.getAlbums().collectLatest { response ->
                if (response.isSuccessful) {
                    _albumState.value =
                        AlbumResponseState.Success(
                            response.message(),
                            response.body() ?: emptyList()
                        )
                } else {
                    _albumState.value = AlbumResponseState.Failed(Exception("No Response Found"))
                }
            }
        }
    }
}