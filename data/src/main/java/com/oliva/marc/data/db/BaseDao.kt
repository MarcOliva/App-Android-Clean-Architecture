package com.oliva.marc.data.db

import io.reactivex.Flowable
import io.reactivex.Single

interface BaseDao<T> {

    fun getAllContacts(): Flowable<List<T>>


    fun getContactById(id: Int): T


    fun deleteAllContacts()


    fun insertContact(t: T)


    fun updateContact(t:T)


    fun deleteContact(t:T): Single<Int>
}