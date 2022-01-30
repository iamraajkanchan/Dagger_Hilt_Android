package com.example.dagger_hilt_android.data.repository

import com.example.dagger_hilt_android.data.room.dao.PostDao
import com.example.dagger_hilt_android.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepository @Inject constructor(private val postDao : PostDao)
{
    suspend fun insertAll(vararg post : Post) = withContext(Dispatchers.IO) {
        postDao.insertAllPosts(*post)
    }

    fun loadAll() = postDao.loadAllPosts()
}