package com.oliva.marc.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oliva.marc.data.db.contact.DaoContact

@Database(entities = [(ContactData.Contact::class)], version = 1, exportSchema = false)
abstract class ContactDB : RoomDatabase() {
    /*companion object {
        private var INSTANCE: ContactDB? = null
        fun getDataBase(context: Context): ContactDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, ContactDB::class.java, "contacts-db")
                    .allowMainThreadQueries().build()
            }
            return INSTANCE as ContactDB
        }
    }*/

    abstract fun contactDao(): DaoContact
}