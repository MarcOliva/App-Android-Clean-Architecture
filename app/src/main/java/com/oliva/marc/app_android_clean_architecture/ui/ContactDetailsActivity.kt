package com.oliva.marc.app_android_clean_architecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oliva.marc.app_android_clean_architecture.R

class ContactDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
    }
}
