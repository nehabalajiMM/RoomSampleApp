package com.example.roomsampleapp.room.repository

import com.example.roomsampleapp.room.dao.ContactsDao
import com.example.roomsampleapp.room.entities.Contact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContactsRepository @Inject constructor(
    private val contactsDao: ContactsDao
) {

    fun getContacts(): Flow<List<Contact>> {
        return contactsDao.getAllContacts()
    }

    fun insertContact(contact: Contact) {
        contactsDao.insertContact(contact)
    }

    fun deleteContact(contact: Contact) {
        contactsDao.deleteContact(contact)
    }
}
