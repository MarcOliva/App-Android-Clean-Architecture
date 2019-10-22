package com.oliva.marc.usecases.contact


import com.oliva.marc.domain.Entity.Entity
import com.oliva.marc.usecases.BaseUseCase
import io.reactivex.Flowable

interface GetContactsUseCase :BaseUseCase{
    fun saveContact(contact: Entity.Contact)
    fun getContacts(): Flowable<List<Entity.Contact>>
    fun deleteContact(contact: Entity.Contact)
}