package com.example.roomsampleapp.ui.add_contact

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.roomsampleapp.databinding.ActivityAddContactBinding
import com.example.roomsampleapp.room.entities.Contact
import com.example.roomsampleapp.room.entities.ContactAddress
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddContactBinding
    private val addContactViewModel: AddContactViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            val contact = Contact(binding.tfContactName.editText?.text.toString(), binding.tfContactEmail.editText?.text.toString(), ContactAddress(binding.tfContactStreetAddress.editText?.text.toString(), binding.tfCity.editText?.text.toString(), binding.tfState.editText?.text.toString(), binding.tfCountry.editText?.text.toString()))
            addContactViewModel.insertContact(contact)
            finish()
        }
    }
}
