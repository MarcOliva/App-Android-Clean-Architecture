package com.oliva.marc.data.repository


import androidx.lifecycle.MutableLiveData
import com.oliva.marc.data.datasource.contact.ContactsDatabaseDataSource
import com.oliva.marc.data.db.ContactData
import com.oliva.marc.domain.Entity.Entity

import com.oliva.marc.domain.repository.contact.ContactsRepository
import io.reactivex.Flowable

class ContactsRepositoryImpl(private val databaseSource: ContactsDatabaseDataSource) :ContactsRepository{
    override fun getContacts(): Flowable<List<Entity.Contact>> = databaseSource.getContacts()
    override fun saveContact(contact: Entity.Contact) {
        databaseSource.persist(contact)
    }

    override fun deleteContact(contact: Entity.Contact) {
        databaseSource.deleteContact(contact)
    }

}