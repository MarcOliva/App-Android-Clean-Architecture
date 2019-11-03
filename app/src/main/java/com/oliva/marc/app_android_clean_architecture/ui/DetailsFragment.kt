package com.oliva.marc.app_android_clean_architecture.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import com.oliva.marc.app_android_clean_architecture.R
import com.oliva.marc.app_android_clean_architecture.ui.base.BaseFragment
import com.oliva.marc.domain.entity.Entity
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : BaseFragment() {

   @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val contactViewModel: DetailsViewModel by lazy {
        ViewModelProviders.of(this,viewModelFactory).get(DetailsViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_contact_button.setOnClickListener {
            contactViewModel.saveContact(Entity.Contact(0,name_edit_text.text.toString(),number_edit_text.text.toString()))
            Navigation.findNavController(view).navigate(R.id.homeFragment)
        }
    }
}
