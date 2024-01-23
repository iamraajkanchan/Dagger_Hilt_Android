package com.example.dagger_hilt_android.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity(tableName = "albums")
@Parcelize
data class Album(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val userId: Int,
    val title: String
) : Parcelable
