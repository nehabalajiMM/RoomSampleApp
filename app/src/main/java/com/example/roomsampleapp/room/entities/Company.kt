package com.example.roomsampleapp.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Company(
    @PrimaryKey(autoGenerate = false)
    val name: String
)
