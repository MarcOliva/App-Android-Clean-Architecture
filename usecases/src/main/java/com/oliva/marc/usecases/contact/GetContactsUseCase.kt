package com.oliva.marc.usecases.contact

import com.oliva.marc.domain.Contact
import com.oliva.marc.usecases.BaseUseCase

interface GetContactsUseCase :BaseUseCase{
    fun getContacts(): List<Contact>
}