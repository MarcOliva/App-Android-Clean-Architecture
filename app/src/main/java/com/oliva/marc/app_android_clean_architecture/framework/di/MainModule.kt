package com.oliva.marc.app_android_clean_architecture.framework.di

import com.oliva.marc.app_android_clean_architecture.framework.di.main.DetailsFragmentModule
import com.oliva.marc.app_android_clean_architecture.framework.di.main.HomeFragmentModule
import com.oliva.marc.app_android_clean_architecture.framework.di.qualifier.PerActivity
import com.oliva.marc.app_android_clean_architecture.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [HomeFragmentModule::class,DetailsFragmentModule::class])
abstract class MainModule {

    //@PerActivity
    @ContributesAndroidInjector
    abstract fun get(): MainActivity
}