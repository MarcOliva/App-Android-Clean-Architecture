package com.oliva.marc.app_android_clean_architecture.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView
import com.oliva.marc.app_android_clean_architecture.R
import com.oliva.marc.app_android_clean_architecture.databinding.ItemContactBinding
import com.oliva.marc.domain.entity.Entity
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class ContactRecyclerAdapter :
    RecyclerView.Adapter<ContactRecyclerAdapter.ContactHolder>() {

    private val onContactItemClickSubject = PublishSubject.create<Entity.Contact>()
    val contactItemClickEvent: Observable<Entity.Contact> = onContactItemClickSubject

    var contacts: List<Entity.Contact>? = null
    fun setContactList(contacts: List<Entity.Contact>) {
        this.contacts = contacts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
       val bind : ItemContactBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
           R.layout.item_contact,parent,false) as ItemContactBinding
        return ContactHolder(bind)
    }

    override fun getItemCount(): Int {
        return contacts?.size ?: 0
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(contacts?.get(position))
        //Log.d("PASO",list?.size.toString())
    }


    inner class ContactHolder(private var itemContactBinding: ItemContactBinding) : RecyclerView.ViewHolder
    (itemContactBinding.root), View.OnClickListener {
        override fun onClick(p0: View?) {

            val contact = contacts?.get(adapterPosition)
            contact?.let {
                val product: Entity.Contact = contact
                onContactItemClickSubject.onNext(product)
            }
        }


        fun bind(contact: Entity.Contact?) {
            itemContactBinding.contactEntity = contact
            itemContactBinding.root.setOnClickListener(this)
            itemContactBinding.executePendingBindings()
        }

    }

}