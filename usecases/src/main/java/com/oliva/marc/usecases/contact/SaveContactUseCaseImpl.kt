package com.oliva.marc.usecases.contact

import com.oliva.marc.domain.Contact
import com.oliva.marc.domain.repository.contact.ContactsRepository

class SaveContactUseCaseImpl(private val repository: ContactsRepository) :SaveContactUseCase{
    override fun saveContact(contact: Contact) {
        repository.saveContact(contact)
    }

}