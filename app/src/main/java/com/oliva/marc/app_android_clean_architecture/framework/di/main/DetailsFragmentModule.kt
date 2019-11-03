package com.oliva.marc.app_android_clean_architecture.framework.di.main

import com.oliva.marc.app_android_clean_architecture.ui.DetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailsFragmentModule {

    @ContributesAndroidInjector
    abstract fun detailsModule(): DetailsFragment
}