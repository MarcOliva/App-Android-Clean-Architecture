/*
package com.oliva.marc.domain.usecases.contact

import com.oliva.marc.domain.entity.Entity
import com.oliva.marc.domain.repository.contact.ContactsRepository
import io.reactivex.Flowable

class GetContactsUseCaseImpl(private val repository:ContactsRepository) : GetContactsUseCase {

    override fun deleteContact(contact: Entity.Contact) {
        repository.deleteContact(contact)
    }

    override fun getContacts():Flowable<List<Entity.Contact>> {
        return repository.getContacts()
    }
    override fun saveContact(contact: Entity.Contact) {
        repository.saveContact(contact)
    }


}*/
