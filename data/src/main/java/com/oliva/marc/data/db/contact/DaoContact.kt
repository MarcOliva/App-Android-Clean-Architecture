package com.oliva.marc.data.db.contact

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oliva.marc.data.db.BaseDao
import com.oliva.marc.data.db.ContactData
import io.reactivex.Flowable

@Dao
interface DaoContact:BaseDao<ContactData.Contact> {
    @Query("select * from contacts")
    override fun getAllContacts(): Flowable<List<ContactData.Contact>>

    @Query("select * from contacts where idContact in (:id)")
    override fun getContactById(id: Int): ContactData.Contact

    @Query("delete from contacts")
    override fun deleteAllContacts()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insertContact(t: ContactData.Contact)

    @Update
    override fun updateContact(t: ContactData.Contact)

    @Delete
    override fun deleteContact(t: ContactData.Contact)
}