package com.oliva.marc.domain.common.transformer

import io.reactivex.FlowableTransformer

abstract class FTransformer<T> : FlowableTransformer<T, T>