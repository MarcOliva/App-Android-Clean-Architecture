package com.oliva.marc.data.datasource.contact

import com.oliva.marc.data.db.contact.DaoContact
import com.oliva.marc.data.mapper.map
import com.oliva.marc.domain.Entity.Entity
import io.reactivex.Flowable
import java.util.concurrent.Executor


class ContactsDatabaseDataSourceImpl(
    private val contactDao: DaoContact,
    private val ioExecutor: Executor
) : ContactsDatabaseDataSource {

    override fun getContacts(): Flowable<List<Entity.Contact>> =
        contactDao.getAllContacts() as Flowable<List<Entity.Contact>>

    override fun persist(contact: Entity.Contact) {
        ioExecutor.execute {
            contactDao.insertContact(contact.map())
        }
    }

    override fun deleteContact(contact: Entity.Contact) = contactDao.deleteContact(contact.map())

}