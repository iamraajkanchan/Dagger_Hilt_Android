package com.example.dagger_hilt_android.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dagger_hilt_android.model.Album

@Database(entities = [Album::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getAlbumDao() : AlbumDao
}