package com.example.roomsampleapp.di

import android.content.Context
import androidx.room.Room
import com.example.roomsampleapp.room.db.ContactsDatabase
import dagger.Module
import dagger.Provides

@Module
class ContactsModule {

    @Provides
    fun providesContactDatabase(
        context: Context
    ) = Room.databaseBuilder(context, ContactsDatabase::class.java, "Contacts Database")
        .addMigrations(ContactsDatabase.migration3To4)
        .build()

    @Provides
    fun provideContactsDao(db: ContactsDatabase) = db.dao()
}
