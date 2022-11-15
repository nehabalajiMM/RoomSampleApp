package com.example.roomsampleapp.ui.add_contact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsampleapp.room.entities.Contact
import com.example.roomsampleapp.room.repository.ContactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddContactViewModel @Inject constructor(
    private val repository: ContactsRepository
) : ViewModel() {

    fun insertContact(contact: Contact) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertContact(contact)
    }
}
