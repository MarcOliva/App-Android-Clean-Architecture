package com.oliva.marc.domain.repository.contact

import com.oliva.marc.domain.common.ResultState
import com.oliva.marc.domain.entity.Entity
import com.oliva.marc.domain.repository.BaseRepository
import io.reactivex.Flowable
import io.reactivex.Single

interface ContactsRepository :BaseRepository{
    fun getContacts(): Flowable<List<Entity.Contact>>
    fun saveContact(contact: Entity.Contact)
    fun deleteContact(contact: Entity.Contact): Single<ResultState<Int>>
}