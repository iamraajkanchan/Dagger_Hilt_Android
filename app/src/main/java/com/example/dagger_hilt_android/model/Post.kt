package com.example.dagger_hilt_android.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = true) val id : Long ,
    val title : String ,
    val description : String
)
