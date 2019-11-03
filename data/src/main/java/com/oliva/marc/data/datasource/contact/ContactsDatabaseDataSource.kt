package com.oliva.marc.data.datasource.contact

import androidx.lifecycle.LiveData
import com.oliva.marc.data.datasource.BaseDataSource
import com.oliva.marc.domain.common.ResultState
import com.oliva.marc.domain.entity.Entity
import io.reactivex.Flowable
import io.reactivex.Single

interface ContactsDatabaseDataSource : BaseDataSource {

    fun getContacts(): Flowable<List<Entity.Contact>>

    fun persist(contact: Entity.Contact)

    fun deleteContact(contact: Entity.Contact): Single<Int>
}