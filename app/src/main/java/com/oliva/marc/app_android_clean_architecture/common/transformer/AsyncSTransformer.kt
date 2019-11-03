package com.oliva.marc.app_android_clean_architecture.common.transformer

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.schedulers.Schedulers
import com.oliva.marc.domain.common.transformer.STransformer


class AsyncSTransformer<T> : STransformer<T>() {

    override fun apply(upstream: Single<T>): SingleSource<T> = upstream.subscribeOn(Schedulers.io())
}