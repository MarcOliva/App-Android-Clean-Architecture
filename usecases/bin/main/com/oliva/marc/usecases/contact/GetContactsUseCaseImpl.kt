package com.oliva.marc.usecases.contact

import com.oliva.marc.domain.common.ResultState
import com.oliva.marc.domain.common.transformer.STransformer
import com.oliva.marc.domain.entity.Entity
import com.oliva.marc.domain.repository.contact.ContactsRepository

import io.reactivex.Flowable
import io.reactivex.Single

class GetContactsUseCaseImpl(private val transformerSingle: STransformer<ResultState<Int>>, private val repository: ContactsRepository) : GetContactsUseCase {

    override fun deleteContact(contact: Entity.Contact) = repository.deleteContact(contact).compose(transformerSingle)


    override fun getContacts(): Flowable<List<Entity.Contact>> {
        return repository.getContacts()
    }
    override fun saveContact(contact: Entity.Contact) {
        repository.saveContact(contact)
    }


}
