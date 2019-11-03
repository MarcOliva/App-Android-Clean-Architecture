package com.oliva.marc.app_android_clean_architecture.common.transformer

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import com.oliva.marc.domain.common.transformer.FTransformer
import org.reactivestreams.Publisher

class AsyncFTransformer<T> : FTransformer<T>() {

    override fun apply(upstream: Flowable<T>): Publisher<T> =
            upstream.subscribeOn(Schedulers.io())
}