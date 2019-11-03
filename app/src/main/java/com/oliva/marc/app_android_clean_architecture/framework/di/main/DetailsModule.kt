package com.oliva.marc.app_android_clean_architecture.framework.di.main

import com.oliva.marc.app_android_clean_architecture.common.transformer.AsyncSTransformer
import com.oliva.marc.app_android_clean_architecture.framework.di.qualifier.PerFragment
import com.oliva.marc.data.datasource.contact.ContactsDatabaseDataSource
import com.oliva.marc.data.datasource.contact.ContactsDatabaseDataSourceImpl
import com.oliva.marc.data.db.contact.DaoContact
import com.oliva.marc.data.repository.ContactsRepositoryImpl
import com.oliva.marc.domain.repository.contact.ContactsRepository
import com.oliva.marc.usecases.contact.GetContactsUseCase
import com.oliva.marc.usecases.contact.GetContactsUseCaseImpl

import dagger.Module
import dagger.Provides
import java.util.concurrent.Executors

@Module
class DetailsModule {
    @Provides
    //@PerFragment
    fun provideDatabaseSourceInDetails(contactDao: DaoContact): ContactsDatabaseDataSource =
        ContactsDatabaseDataSourceImpl(contactDao, Executors.newSingleThreadExecutor())


    @Provides
    //@PerFragment
    fun provideRepositoryInDetails(
        databaseSource: ContactsDatabaseDataSource
    ): ContactsRepository {
        return ContactsRepositoryImpl(databaseSource)
    }
    @Provides
    //@PerFragment
    fun provideGetContactsUseCaseImplInDetails(repository: ContactsRepository): GetContactsUseCase = GetContactsUseCaseImpl(AsyncSTransformer(), repository)
}