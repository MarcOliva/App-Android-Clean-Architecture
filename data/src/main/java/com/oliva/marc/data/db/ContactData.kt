package com.oliva.marc.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class ContactData{
    @Entity(tableName = "contacts")
    data class Contact(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "idContact")
        var id: Int,

        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "number")
        var number: String

    ):ContactData()
}