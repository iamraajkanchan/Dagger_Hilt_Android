package com.example.dagger_hilt_android.model

import android.content.Context
import com.google.gson.Gson
import java.io.IOException
import kotlin.jvm.Throws

class AlbumManager {
    var albums = emptyArray<Album>()
    private var currentAlbumIndex = 0

    @Throws(IOException::class)
    fun populateAlbumFromAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        albums = gson.fromJson(json, Array<Album>::class.java)
    }

    fun populateQuotes(albums: Array<Album>) {
        this.albums = albums
    }

    fun getCurrentAlbum(): Album = albums[currentAlbumIndex]

    fun getNextAlbum(): Album {
        if (currentAlbumIndex == albums.size - 1) return albums[currentAlbumIndex]
        return albums[++currentAlbumIndex]
    }

    fun getPreviousAlbum(): Album {
        if (currentAlbumIndex == 0) return albums[currentAlbumIndex]
        return albums[--currentAlbumIndex]
    }

}