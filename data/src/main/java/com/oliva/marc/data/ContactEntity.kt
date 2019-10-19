package com.oliva.marc.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.oliva.marc.domain.Contact

@Entity(tableName = "contacts")
internal data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idContact")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "number")
    var number: String = ""

) {
    companion object {
        fun from(contact: Contact): ContactEntity {
            return ContactEntity(contact.id, contact.name, contact.number)
        }
    }

    fun toContact(): Contact {
        return Contact(id, name, number)
    }
}