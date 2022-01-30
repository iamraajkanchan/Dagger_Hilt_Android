package com.example.dagger_hilt_android.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_hilt_android.data.repository.PostRepository
import com.example.dagger_hilt_android.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository : PostRepository) : ViewModel()
{
    val postLiveData = postRepository.loadAll()

    fun insertAll(vararg post : Post) = viewModelScope.launch(Dispatchers.IO) {
        postRepository.insertAll(*post)
    }

}