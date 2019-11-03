package com.oliva.marc.app_android_clean_architecture.framework.di

import android.content.Context
import androidx.room.Room
import com.oliva.marc.app_android_clean_architecture.framework.di.qualifier.ApplicationContext
import com.oliva.marc.data.db.ContactDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    //@Singleton
    @Provides
    fun provideMyDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, ContactDB::class.java, "mydatabase")
        .build()

    //@Singleton
    @Provides
    fun provideContactDao(myDatabase: ContactDB) = myDatabase.contactDao()
}