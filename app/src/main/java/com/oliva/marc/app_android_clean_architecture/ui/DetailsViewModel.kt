package com.oliva.marc.app_android_clean_architecture.ui

import com.oliva.marc.app_android_clean_architecture.ui.base.BaseViewModel
import com.oliva.marc.domain.entity.Entity
import com.oliva.marc.usecases.contact.GetContactsUseCase
import javax.inject.Inject

class DetailsViewModel@Inject constructor(private val contactsUseCase: GetContactsUseCase) :BaseViewModel(){

    private var contactRecyclerAdapter: ContactRecyclerAdapter? = null
    fun saveContact(contact: Entity.Contact) {
        contactsUseCase.saveContact(contact)
        contactRecyclerAdapter?.notifyDataSetChanged()
    }
}