package com.example.roomsampleapp.room.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    private val contactId: Int,
    private val contactName: String,
    private val contactEmail: String,
    @Embedded
    private val contactAddress: ContactAddress
)
