package com.example.roomsampleapp.di

import android.content.Context
import com.example.roomsampleapp.ui.add_contact.AddContactActivity
import com.example.roomsampleapp.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContactsModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: AddContactActivity)
}
