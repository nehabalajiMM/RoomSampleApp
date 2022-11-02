package com.example.roomsampleapp.room.repository

import androidx.lifecycle.LiveData
import com.example.roomsampleapp.room.dao.ContactsDao
import com.example.roomsampleapp.room.entities.Contact
import javax.inject.Inject

class ContactsRepository @Inject constructor(
    private val contactsDao: ContactsDao
) {

    fun getContacts(): LiveData<List<Contact>> {
        return contactsDao.getAllContacts()
    }

    fun insertContact(contact: Contact) {
        contactsDao.insertContact(contact)
    }
}
