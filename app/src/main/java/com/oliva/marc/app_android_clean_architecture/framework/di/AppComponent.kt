package com.oliva.marc.app_android_clean_architecture.framework.di

import com.oliva.marc.app_android_clean_architecture.framework.MyApplication
import com.oliva.marc.app_android_clean_architecture.framework.di.main.DetailsModule
import com.oliva.marc.app_android_clean_architecture.framework.di.main.HomeModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        AppModule::class,
        MainModule::class,
        HomeModule::class
        //DetailsModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApplication>()
}