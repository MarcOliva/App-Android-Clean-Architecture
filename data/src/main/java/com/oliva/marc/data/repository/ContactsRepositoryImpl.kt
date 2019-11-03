package com.oliva.marc.data.repository


import androidx.lifecycle.LiveData
import com.oliva.marc.data.datasource.contact.ContactsDatabaseDataSource
import com.oliva.marc.domain.common.ResultState
import com.oliva.marc.domain.entity.Entity

import com.oliva.marc.domain.repository.contact.ContactsRepository
import io.reactivex.Flowable
import io.reactivex.Single

class ContactsRepositoryImpl(private val databaseSource: ContactsDatabaseDataSource) :ContactsRepository{
    override fun getContacts(): Flowable<List<Entity.Contact>> = databaseSource.getContacts()
    override fun saveContact(contact: Entity.Contact) {
        databaseSource.persist(contact)
    }

    override fun deleteContact(contact: Entity.Contact): Single<ResultState<Int>> =
        databaseSource.deleteContact(contact).map {
            ResultState.Success(it) as ResultState<Int>
        }.onErrorReturn {
            ResultState.Error(it, null)
        }


}