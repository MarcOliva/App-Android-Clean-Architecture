package com.oliva.marc.app_android_clean_architecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.oliva.marc.app_android_clean_architecture.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var contactViewModel: ContactViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)
        fab.setOnClickListener { contactViewModel?.addNewContact(applicationContext) }
        setupListUpdate()
    }

    fun setupListUpdate() {
        // contactViewModel?.getContacts()
    }
}
