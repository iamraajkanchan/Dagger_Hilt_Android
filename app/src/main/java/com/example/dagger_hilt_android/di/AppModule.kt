package com.example.dagger_hilt_android.di

import android.content.Context
import androidx.room.Room
import com.example.dagger_hilt_android.data.room.dao.PostDao
import com.example.dagger_hilt_android.data.room.database.MyRoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule
{

    @Provides
    @Singleton
    fun getDBName() : String = "RoomDB"

    @Provides
    @Singleton
    fun getRoomDB(@ApplicationContext context : Context , name : String) : MyRoomDB =
        Room.databaseBuilder(context , MyRoomDB::class.java , name).build()

    @Provides
    @Singleton
    fun getPostDao(db : MyRoomDB) : PostDao = db.getPostDao()
}