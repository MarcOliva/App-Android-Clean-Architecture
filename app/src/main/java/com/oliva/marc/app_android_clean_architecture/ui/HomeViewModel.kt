package com.oliva.marc.app_android_clean_architecture.ui

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.navigation.Navigation
import com.oliva.marc.app_android_clean_architecture.R

import com.oliva.marc.app_android_clean_architecture.common.OperationLiveData
import com.oliva.marc.app_android_clean_architecture.ui.base.BaseViewModel
import com.oliva.marc.domain.common.ResultState

import com.oliva.marc.domain.entity.Entity
import com.oliva.marc.usecases.contact.GetContactsUseCase

import io.reactivex.disposables.Disposable
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val contactsUseCase: GetContactsUseCase) :
    BaseViewModel() {
    private var tempDispossable: Disposable? = null
    private val listContacts = MutableLiveData<Entity.Contact>()
    private val contactToBeDeleted = MutableLiveData<Entity.Contact>()

    fun deleteContact(contact: Entity.Contact) {
        contactToBeDeleted.postValue(contact)
    }
    val deletedContactLiveData: LiveData<ResultState<Int>> =
        Transformations.switchMap(contactToBeDeleted) {
            OperationLiveData<ResultState<Int>> {
                contactsUseCase.deleteContact(it).toFlowable().subscribe {result->
                    postValue((result))
                }
            }
        }
    fun addNewContact(view: View) {
        Navigation.findNavController(view).navigate(R.id.navigateToContactDetailFragment)
    }

    val contacts: LiveData<List<Entity.Contact>> =
        Transformations.switchMap(listContacts) {
            OperationLiveData<List<Entity.Contact>> {
                if (tempDispossable?.isDisposed != true) {
                    tempDispossable?.dispose()
                }
                tempDispossable = contactsUseCase.getContacts().subscribe {
                    postValue(it)
                }
                tempDispossable?.track()
            }
        }

    fun getContacts(){
        listContacts.postValue(null)
    }





}