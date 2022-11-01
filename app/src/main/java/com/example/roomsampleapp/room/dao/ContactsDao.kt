package com.example.roomsampleapp.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomsampleapp.room.entities.Contact

@Dao
interface ContactsDao {
    @Insert
    fun insertContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getAllContacts(): LiveData<List<Contact>>
}
