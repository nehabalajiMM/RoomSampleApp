package com.example.roomsampleapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.roomsampleapp.adapter.ContactsListAdapter
import com.example.roomsampleapp.databinding.ActivityMainBinding
import com.example.roomsampleapp.ui.add_contact.AddContactActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactsListAdapter = ContactsListAdapter()
        binding.rvContactsList.adapter = contactsListAdapter

        mainViewModel.contacts.observe(this@MainActivity) {
            if (it.isNotEmpty()) {
                binding.tvAddContact.visibility = View.GONE
                contactsListAdapter.differ.submitList(it)
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
