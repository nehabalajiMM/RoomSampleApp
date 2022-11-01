package com.example.roomsampleapp.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomsampleapp.room.dao.ContactsDao
import com.example.roomsampleapp.room.entities.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun dao(): ContactsDao
}
