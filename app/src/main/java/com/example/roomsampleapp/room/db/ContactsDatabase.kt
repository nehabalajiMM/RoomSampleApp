package com.example.roomsampleapp.room.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.AutoMigrationSpec
import com.example.roomsampleapp.room.converter.Converters
import com.example.roomsampleapp.room.dao.ContactsDao
import com.example.roomsampleapp.room.entities.Contact

@Database(
    entities = [Contact::class],
    version = 3,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec = ContactsDatabase.Migration2To3::class)
    ]
)
@TypeConverters(Converters::class)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun dao(): ContactsDao

    @RenameColumn(tableName = "Contact", fromColumnName = "profilePhoto", toColumnName = "contactProfilePhoto")
    class Migration2To3 : AutoMigrationSpec
}
