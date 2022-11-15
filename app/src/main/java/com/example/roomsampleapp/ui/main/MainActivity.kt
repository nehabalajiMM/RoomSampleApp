package com.example.roomsampleapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.roomsampleapp.RoomSampleApplication
import com.example.roomsampleapp.adapter.ContactsListAdapter
import com.example.roomsampleapp.databinding.ActivityMainBinding
import com.example.roomsampleapp.ui.add_contact.AddContactActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as RoomSampleApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactsListAdapter = ContactsListAdapter()
        binding.rvContactsList.adapter = contactsListAdapter

        mainViewModel.contacts.observe(this@MainActivity) {
            contactsListAdapter.differ.submitList(it)
            if (it.isNotEmpty()) {
                binding.tvAddContact.visibility = View.GONE
            } else {
                binding.tvAddContact.visibility = View.VISIBLE
            }
        }

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        }
    }
}
