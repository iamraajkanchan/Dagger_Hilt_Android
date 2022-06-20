package com.example.dagger_hilt_android.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.dagger_hilt_android.model.Post

/**
 * PostDao is used to write queries for Room Database.
 * */
@Dao
interface PostDao
{
    /**
     * insertPost method is used to write insert query for storing Post details in Room Database.
     * */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertPost(post : Post)

    /**
     * updatePost method is used to write update query for updating Post details in Room Database.
     * */
    @Update
    suspend fun updatePost(post : Post)

    /**
     * deletePost method is used to write delete query for deleting Post details from Room Database.
     * */
    @Delete
    suspend fun deletePost(post : Post)

    /**
     * loadAllPosts method is used to fetch all Post details from Room Database.
     * */
    @Query("SELECT * FROM posts")
    fun loadAllPosts() : LiveData<List<Post>>

    /**
     * insertAllPosts method is used to multiple Post details into Room Database.
     * */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertAllPosts(vararg post : Post)
}