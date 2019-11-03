package com.oliva.marc.data.datasource.contact

import androidx.lifecycle.LiveData
import com.oliva.marc.data.db.contact.DaoContact
import com.oliva.marc.data.mapper.map
import com.oliva.marc.domain.entity.Entity
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.concurrent.Executor


class ContactsDatabaseDataSourceImpl(
    private val contactDao: DaoContact,
    private val ioExecutor: Executor
) : ContactsDatabaseDataSource {

    override fun getContacts(): Flowable<List<Entity.Contact>> = contactDao.getAllContacts().map { it ->
        it.map {
            it.map()
        }
    }

    override fun persist(contact: Entity.Contact) {
        ioExecutor.execute {
            contactDao.insertContact(contact.map())
        }
    }

    override fun deleteContact(contact: Entity.Contact) = contactDao.deleteContact(contact.map())

}