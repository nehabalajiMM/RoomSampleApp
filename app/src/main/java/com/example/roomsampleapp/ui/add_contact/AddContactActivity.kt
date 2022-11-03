package com.example.roomsampleapp.ui.add_contact

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.roomsampleapp.databinding.ActivityAddContactBinding
import com.example.roomsampleapp.room.entities.Contact
import com.example.roomsampleapp.room.entities.ContactAddress
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddContactBinding
    private val addContactViewModel: AddContactViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            lifecycleScope.launch {
                it.isEnabled = false
                val contact = Contact(binding.tfContactName.editText?.text.toString(), binding.tfContactEmail.editText?.text.toString(), ContactAddress(binding.tfContactStreetAddress.editText?.text.toString(), binding.tfCity.editText?.text.toString(), binding.tfState.editText?.text.toString(), binding.tfCountry.editText?.text.toString()), getBitmap())
                addContactViewModel.insertContact(contact)
                finish()
            }
        }
    }

    private suspend fun getBitmap(): Bitmap {
        val loading = ImageLoader(this)
        val request = ImageRequest.Builder(this)
            .data("https://www.placecage.com/175/175")
            .build()

        val result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }
}
