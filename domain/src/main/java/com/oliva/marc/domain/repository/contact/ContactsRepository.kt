package com.oliva.marc.domain.repository.contact

import com.oliva.marc.domain.Entity.Entity
import com.oliva.marc.domain.repository.BaseRepository
import io.reactivex.Flowable

interface ContactsRepository :BaseRepository{
    fun getContacts(): Flowable<List<Entity.Contact>>
    fun saveContact(contact: Entity.Contact)
    fun deleteContact(contact: Entity.Contact)
}