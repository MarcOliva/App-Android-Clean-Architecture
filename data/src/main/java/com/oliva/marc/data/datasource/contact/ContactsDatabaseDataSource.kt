package com.oliva.marc.data.datasource.contact

import androidx.lifecycle.LiveData
import com.oliva.marc.data.datasource.BaseDataSource
import com.oliva.marc.data.db.ContactData
import com.oliva.marc.domain.Entity.Entity
import io.reactivex.Flowable

interface ContactsDatabaseDataSource : BaseDataSource {

    fun getContacts(): Flowable<List<Entity.Contact>>

    fun persist(contact: Entity.Contact)

    fun deleteContact(contact: Entity.Contact)
}