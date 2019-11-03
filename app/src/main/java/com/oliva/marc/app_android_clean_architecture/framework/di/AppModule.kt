package com.oliva.marc.app_android_clean_architecture.framework.di

import android.content.Context
import android.content.res.Resources
import com.oliva.marc.app_android_clean_architecture.framework.MyApplication
import com.oliva.marc.app_android_clean_architecture.framework.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ DbModule::class])
abstract class AppModule {

    @ApplicationContext
    @Binds
    abstract fun provideApplicationContext(myApplication: MyApplication): Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideAppResources(context: Context): Resources {
            return context.resources
        }
    }
}