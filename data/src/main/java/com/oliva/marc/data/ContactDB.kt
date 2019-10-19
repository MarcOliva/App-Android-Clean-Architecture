package com.oliva.marc.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(ContactEntity::class)], version = 1, exportSchema = false)
abstract class ContactDB : RoomDatabase() {
    companion object {
        private var INSTANCE: ContactDB? = null
        fun getDataBase(context: Context): ContactDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, ContactDB::class.java, "contacts-db")
                    .allowMainThreadQueries().build()
            }
            return INSTANCE as ContactDB
        }
    }

    abstract fun daoContact(): DaoContact
}