package com.example.dagger_hilt_android.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_hilt_android.data.repository.PostRepository
import com.example.dagger_hilt_android.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * PostViewModel is a ViewModel for
 * */
@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository : PostRepository) : ViewModel()
{
    /**
     * postLiveData is used to retrieve data from Room Database
     * */
    val postLiveData : LiveData<List<Post>> = postRepository.loadAll()

    /**
     * insertAll method is used to insert Post objects into room database
     * */
    fun insertAll(vararg post : Post) : Job = viewModelScope.launch(Dispatchers.IO) {
        postRepository.insertAll(*post)
    }

}