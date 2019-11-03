package com.oliva.marc.app_android_clean_architecture.ui


import android.os.Bundle
import android.view.View
import com.oliva.marc.app_android_clean_architecture.R
import com.oliva.marc.app_android_clean_architecture.common.extension.observe
import com.oliva.marc.app_android_clean_architecture.ui.base.BaseActivity


class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    override fun getNavControllerId(): View = R.id.activityMainHomeHostFragment as View

}


