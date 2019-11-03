package com.oliva.marc.app_android_clean_architecture.framework.di.main

import com.oliva.marc.app_android_clean_architecture.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentModule {

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment
}