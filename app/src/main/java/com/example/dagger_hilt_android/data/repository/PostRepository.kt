package com.example.dagger_hilt_android.data.repository

import androidx.lifecycle.LiveData
import com.example.dagger_hilt_android.data.room.dao.PostDao
import com.example.dagger_hilt_android.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * PostRepository is used as repository for PostViewModel
 * */
class PostRepository @Inject constructor(private val postDao : PostDao)
{
    /**
     * insertAll method is used to insert all the posts into Room Database.
     * */
    suspend fun insertAll(vararg post : Post) : Unit = withContext(Dispatchers.IO) {
        postDao.insertAllPosts(*post)
    }

    /**
     * loadAll method is used to retrieve data from Room Database.
     * */
    fun loadAll() : LiveData<List<Post>> = postDao.loadAllPosts()
}