package com.example.dagger_hilt_android.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_hilt_android.model.PostItem
import com.example.dagger_hilt_android.retrofit.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(val postRepository : PostRepository) : ViewModel()
{
    private val _postMutableLiveData : MutableLiveData<List<PostItem>> = MutableLiveData()
    private val postLiveData : LiveData<List<PostItem>> = _postMutableLiveData

    fun getPostLiveData() : LiveData<List<PostItem>> = postLiveData

    fun getPost() = viewModelScope.launch(Dispatchers.IO) {
        val posts = postRepository.getPost()
        _postMutableLiveData.value = posts
    }

}