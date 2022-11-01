package com.example.roomsampleapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsampleapp.room.entities.Contact
import com.example.roomsampleapp.room.entities.ContactAddress
import com.example.roomsampleapp.room.repository.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ContactsRepository
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertContact(Contact("testName", "test@gmail.com", ContactAddress("test", "test", "test", "test")))
        }
    }

    var contacts: LiveData<List<Contact>> = repository.getContacts()

    fun insertContact(contact: Contact) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertContact(contact)
    }

    fun deleteContact(contact: Contact) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteContact(contact)
    }
}
