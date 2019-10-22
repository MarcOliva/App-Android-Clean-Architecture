package com.oliva.marc.app_android_clean_architecture.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oliva.marc.app_android_clean_architecture.R

import com.oliva.marc.domain.Entity.Entity


class ContactRecyclerAdapter(var contactViewModel: ContactViewModel, listener: OnItemClickListener) :
    RecyclerView.Adapter<ContactRecyclerAdapter.ContactHolder>() {

    var contacts: List<Entity.Contact>? = null
    private var listenerContact: OnItemClickListener = listener
    fun setContactList(contacts: List<Entity.Contact>) {
        this.contacts = contacts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        return ContactHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return contacts?.size ?: 0
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val currentContact: Entity.Contact? = contacts?.get(position)
        val nameContact = currentContact?.name
        val numberContact = currentContact?.number

        holder.mName.text = nameContact
        holder.mNumber.text = numberContact

        holder.bind(currentContact, listenerContact)
    }


    class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mName = itemView.findViewById<TextView>(R.id.name_contact)!!
        var mNumber = itemView.findViewById<TextView>(R.id.number_contact)!!

        fun bind(contact: Entity.Contact?, listener: OnItemClickListener) {
            itemView.setOnClickListener {
                listener.onItemClick(contact)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(contact: Entity.Contact?)
    }
}