package com.oliva.marc.usecases.contact

import com.oliva.marc.domain.Contact
import com.oliva.marc.domain.repository.contact.ContactsRepository

class GetContactsUseCaseImpl(private val repository:ContactsRepository) :GetContactsUseCase{
    override fun getContacts(): List<Contact> {
        return repository.getContacts()
    }

}