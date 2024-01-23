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

    @Insert(Album::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertAlbumInDatabase(album: List<Album>)

    @Delete
    suspend fun deleteAlbum(album: Album)
}