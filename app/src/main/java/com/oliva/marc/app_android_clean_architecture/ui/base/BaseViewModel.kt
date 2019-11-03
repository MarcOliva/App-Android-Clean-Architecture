package com.oliva.marc.app_android_clean_architecture.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel :ViewModel(){
    private val mDisposables = CompositeDisposable()

    protected fun Disposable.track() {
        mDisposables.add(this)
    }

    override fun onCleared() {
        mDisposables.clear()
        super.onCleared()
    }
}