package com.example.roomsampleapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.roomsampleapp.adapter.ContactsListAdapter
import com.example.roomsampleapp.databinding.ActivityMainBinding
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
                contactsListAdapter.differ.submitList(it)
            } else {
                Log.e("EMPTY_LIST", "list is empty")
            }
        }
    }
}
