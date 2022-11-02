package com.example.roomsampleapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomsampleapp.room.entities.Contact
import com.example.roomsampleapp.room.repository.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ContactsRepository
) : ViewModel() {

    var contacts: LiveData<List<Contact>> = repository.getContacts()
}
