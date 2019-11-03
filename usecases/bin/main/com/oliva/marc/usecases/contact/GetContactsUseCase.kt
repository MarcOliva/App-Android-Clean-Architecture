package com.oliva.marc.usecases.contact

import com.oliva.marc.domain.common.ResultState
import com.oliva.marc.domain.entity.Entity
import com.oliva.marc.usecases.BaseUseCase
import io.reactivex.Flowable
import io.reactivex.Single


interface GetContactsUseCase : BaseUseCase {
    fun saveContact(contact: Entity.Contact)
    fun getContacts(): Flowable<List<Entity.Contact>>
    fun deleteContact(contact: Entity.Contact):Single<ResultState<Int>>
}