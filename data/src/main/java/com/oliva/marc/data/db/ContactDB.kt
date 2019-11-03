package com.oliva.marc.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oliva.marc.data.db.contact.DaoContact

@Database(entities = [(ContactData.Contact::class)], version = 1, exportSchema = false)
abstract class ContactDB : RoomDatabase() {
    abstract fun contactDao(): DaoContact
}