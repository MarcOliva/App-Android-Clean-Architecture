package com.oliva.marc.app_android_clean_architecture.framework.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oliva.marc.app_android_clean_architecture.framework.di.qualifier.ViewModelKey
import com.oliva.marc.app_android_clean_architecture.ui.DetailsViewModel
import com.oliva.marc.app_android_clean_architecture.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    internal abstract fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel
}