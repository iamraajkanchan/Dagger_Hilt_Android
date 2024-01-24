package com.example.dagger_hilt_android.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dagger_hilt_android.model.Album
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {
    @Query("SELECT * FROM albums")
    fun getAlbumsFromDatabase(): Flow<List<Album>>

    // Note: Do not use the OnConflictStrategy.ABORT. You application will crash abnormally and you will have no idea why it happened.
    @Insert(Album::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertAlbumInDatabase(albums: List<Album>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSingleAlbumInDatabase(album: Album)

    @Delete
    suspend fun deleteAlbum(album: Album)
}