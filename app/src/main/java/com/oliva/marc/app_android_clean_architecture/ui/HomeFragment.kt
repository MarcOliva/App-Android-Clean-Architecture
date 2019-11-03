package com.oliva.marc.app_android_clean_architecture.ui


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager

import com.oliva.marc.app_android_clean_architecture.R
import com.oliva.marc.app_android_clean_architecture.common.extension.applyIoScheduler
import com.oliva.marc.app_android_clean_architecture.common.extension.observe
import com.oliva.marc.app_android_clean_architecture.ui.base.BaseFragment
import com.oliva.marc.domain.common.ResultState
import com.oliva.marc.domain.entity.Entity
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val contactViewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }
    //private var adapter: ContactRecyclerAdapter? = null

    private val adapter: ContactRecyclerAdapter by lazy {
        ContactRecyclerAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        fab.setOnClickListener { context?.let { contactViewModel.addNewContact(view) } }
        observe(contactViewModel.contacts, ::showContacts)
        observe(contactViewModel.deletedContactLiveData, ::onContactDeleted)
        contactViewModel.getContacts()


    }

    @SuppressLint("CheckResult")
    private fun setAdapter() {
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter
        adapter.contactItemClickEvent.applyIoScheduler()?.subscribe { it ->
            contactViewModel.deleteContact(it)
        }

    }

    private fun showContacts(contacts: List<Entity.Contact>) {
        //Log.d("CONTACT", contacts[0].name)
        adapter.setContactList(contacts)
        adapter.notifyDataSetChanged()
    }

    private fun onContactDeleted(resultState: ResultState<Int>) {
        when (resultState) {
            is ResultState.Success -> {
                Toast.makeText(activity, "Contact ${resultState.data} deleted", Toast.LENGTH_SHORT)
                    .show()
            }
            is ResultState.Error -> Toast.makeText(
                activity,
                resultState.throwable.message,
                Toast.LENGTH_SHORT
            ).show()
        }


    }


}
