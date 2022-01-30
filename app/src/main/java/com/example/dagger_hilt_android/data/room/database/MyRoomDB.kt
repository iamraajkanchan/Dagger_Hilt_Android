package com.example.dagger_hilt_android.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dagger_hilt_android.data.room.dao.PostDao
import com.example.dagger_hilt_android.model.Post

@Database(entities = [Post::class] , version = 1 , exportSchema = false)
abstract class MyRoomDB : RoomDatabase()
{
    abstract fun getPostDao() : PostDao
}