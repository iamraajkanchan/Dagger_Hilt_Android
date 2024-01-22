package com.example.dagger_hilt_android.model

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.ComparisonFailure
import org.junit.Test
import org.junit.runner.RunWith
import java.io.FileNotFoundException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class AlbumManagerTest {
    private lateinit var albumManager: AlbumManager
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setUp() {
        albumManager = AlbumManager()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun loadFileFromAssets_valid_fileName() {
        readFileFromAsset("albums.json")
    }

    @Test(expected = FileNotFoundException::class)
    fun loadFileFromAssets_invalid_fileName() {
        readFileFromAsset("invalid.json")
    }

    @Test(expected = FileNotFoundException::class)
    fun loadFileFromAssets_empty_fileName() {
        readFileFromAsset("")
    }

    @Throws(FileNotFoundException::class)
    private fun readFileFromAsset(fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        albumManager.albums = gson.fromJson(json, Array<Album>::class.java)
        assertEquals(100, albumManager.albums.size)
    }

    @Test
    fun populateAlbumFromAssets_with_valid_fileName() {
        albumManager.populateAlbumFromAssets(context, "albums.json")
        assertEquals(100, albumManager.albums.size)
    }

    @Test(expected = FileNotFoundException::class)
    fun populateAlbumFromAssets_with_invalid_fileName() {
        albumManager.populateAlbumFromAssets(context, "invalid.json")
    }

    @Test(expected = FileNotFoundException::class)
    fun populateAlbumFromAssets_with_empty_fileName() {
        albumManager.populateAlbumFromAssets(context, "")
    }

    @Test
    fun testPreviousAlbum_return_correct_album() {
        // Arrange
        populateSampleAlbums()
        // Act
        val album = albumManager.getPreviousAlbum()
        // Assert
        assertEquals("Camilla Cabello Collections", album.title)
    }

    @Test
    fun testNextAlbum_return_correct_album() {
        // Arrange
        populateSampleAlbums()
        // Act
        val album = albumManager.getNextAlbum()
        assertEquals("Taylor Swift Album", album.title)
    }

    @Test(expected = ComparisonFailure::class)
    fun testNextAlbum_return_incorrect_album() {
        // Arrange
        populateSampleAlbums()
        // Act
        val album = albumManager.getNextAlbum()
        assertEquals("Taylor Swift Red", album.title)
    }

    private fun populateSampleAlbums() {
        albumManager.populateQuotes(
            arrayOf(
                Album(902, 9029, "Camilla Cabello Album"),
                Album(903, 9039, "Taylor Swift Album"),
                Album(904, 9049, "Taylor Swift Red"),
                Album(905, 9059, "Ariana Grande Album"),
                Album(906, 9069, "Selena Gomez Album"),
            )
        )
    }
}