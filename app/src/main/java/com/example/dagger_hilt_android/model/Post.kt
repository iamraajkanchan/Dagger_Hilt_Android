package com.example.dagger_hilt_android.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Post Model is create schema for storing Post details in Room Database.
 * */
@Entity(tableName = "posts")
data class Post(
    /** id of a Post. */
    @PrimaryKey(autoGenerate = true) val id : Long ,
    /** title of a Post. */
    val title : String ,
    /** description of Post. */
    val description : String ,
)
