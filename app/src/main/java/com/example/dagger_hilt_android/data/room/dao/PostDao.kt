package com.example.dagger_hilt_android.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.dagger_hilt_android.model.Post

@Dao
interface PostDao
{
    @Insert
    suspend fun insertPost(post : Post)

    @Update
    suspend fun updatePost(post : Post)

    @Delete
    suspend fun deletePost(post : Post)

    @Query("SELECT * FROM posts")
    fun loadAllPosts() : LiveData<List<Post>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertAllPosts(vararg post : Post)
}