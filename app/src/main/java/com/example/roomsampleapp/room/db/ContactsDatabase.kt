package com.example.roomsampleapp.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roomsampleapp.room.converter.Converters
import com.example.roomsampleapp.room.dao.ContactsDao
import com.example.roomsampleapp.room.entities.Contact

@Database(entities = [Contact::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun dao(): ContactsDao
}
