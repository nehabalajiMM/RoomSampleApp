package com.example.roomsampleapp.di

import android.content.Context
import androidx.room.Room
import com.example.roomsampleapp.room.dao.ContactsDao
import com.example.roomsampleapp.room.db.ContactsDatabase
import com.example.roomsampleapp.room.repository.ContactsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ContactsModule {

    @Singleton
    @Provides
    fun providesContactDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ContactsDatabase::class.java, "Contacts Database")
        .addMigrations(ContactsDatabase.migration3To4)
        .build()

    @Singleton
    @Provides
    fun provideContactsDao(db: ContactsDatabase) = db.dao()

    @Singleton
    @Provides
    fun provideRepository(contactsDao: ContactsDao) = ContactsRepository(contactsDao)
}
