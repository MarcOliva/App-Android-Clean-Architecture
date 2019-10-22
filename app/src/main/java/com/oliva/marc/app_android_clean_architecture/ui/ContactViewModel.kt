package com.oliva.marc.app_android_clean_architecture.ui

import android.content.Context
import android.content.Intent
import android.telecom.Call
import android.view.View
import androidx.annotation.InspectableProperty
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oliva.marc.domain.Entity.Entity


class ContactViewModel: ViewModel() {


        private var contactRecyclerAdapter : ContactRecyclerAdapter? = null

        fun setContactsInRecyclerAdapter(contacts:List<Entity.Contact>){
                contactRecyclerAdapter?.setContactList(contacts)
                contactRecyclerAdapter?.notifyDataSetChanged()
        }

        fun saveContact(contact: Entity.Contact){
                //getContactsUseCase.saveContact(contact)
                contactRecyclerAdapter?.notifyDataSetChanged()
        }
        fun deleteContact(contact: Entity.Contact){
                //getContactsUseCase.deleteContact(contact)
                contactRecyclerAdapter?.notifyDataSetChanged()
        }
        fun addNewContact(context: Context){
                val intent= Intent(context,ContactDetailsActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)

        }
      /*  fun getContacts(): LiveData<List<Entity.Contact>>{

                //return getContactsUseCase.getContacts()
                return null
        }*/


}