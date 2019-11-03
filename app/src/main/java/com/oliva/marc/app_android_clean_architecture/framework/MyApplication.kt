package com.oliva.marc.app_android_clean_architecture.framework

import android.content.Context
import androidx.multidex.MultiDex
import com.oliva.marc.app_android_clean_architecture.framework.di.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApplication : DaggerApplication() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerAppComponent.builder().create(this)
    }
}