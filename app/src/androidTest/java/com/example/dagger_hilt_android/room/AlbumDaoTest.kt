package com.example.dagger_hilt_android.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.dagger_hilt_android.model.Album
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class AlbumDaoTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var albumDao: AlbumDao
    private val context = ApplicationProvider.getApplicationContext() as Context

    @Before
    fun setUp() {
        appDatabase =
            Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries()
                .build()
        albumDao = appDatabase.getAlbumDao()
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

}