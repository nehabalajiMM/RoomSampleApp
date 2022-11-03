package com.example.roomsampleapp.room.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomsampleapp.room.converter.Converters
import com.example.roomsampleapp.room.dao.ContactsDao
import com.example.roomsampleapp.room.entities.Company
import com.example.roomsampleapp.room.entities.Contact

@Database(
    entities = [Contact::class, Company::class],
    version = 4,
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

    companion object {
        val migration3To4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS Company (name CHAR NOT NULL PRIMARY KEY)")
            }
        }
    }
}
