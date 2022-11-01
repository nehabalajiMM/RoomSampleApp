package com.example.roomsampleapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.roomsampleapp.room.entities.Contact
import com.example.roomsampleapp.room.repository.ContactsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: ContactsRepository
) : ViewModel() {

    val contacts: Flow<List<Contact>> = repository.getContacts()

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }

    fun deleteContact(contact: Contact) {
        repository.deleteContact(contact)
    }
}
