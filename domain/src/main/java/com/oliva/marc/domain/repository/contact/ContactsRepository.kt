package com.oliva.marc.domain.repository.contact

import com.oliva.marc.domain.Contact
import com.oliva.marc.domain.repository.BaseRepository

interface ContactsRepository :BaseRepository{
    fun getContacts(): List<Contact>
    fun saveContact(contact: Contact)

}