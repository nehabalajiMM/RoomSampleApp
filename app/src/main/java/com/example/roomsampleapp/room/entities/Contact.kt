package com.example.roomsampleapp.room.entities

import android.graphics.Bitmap
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    val contactName: String,
    val contactEmail: String,
    @Embedded
    val contactAddress: ContactAddress,
    val profilePhoto: Bitmap,
    @PrimaryKey(autoGenerate = true)
    val contactId: Long = 0L
)
