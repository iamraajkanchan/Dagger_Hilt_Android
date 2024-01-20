package com.example.dagger_hilt_android.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class Album(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val userId: Int,
    val title: String
)
