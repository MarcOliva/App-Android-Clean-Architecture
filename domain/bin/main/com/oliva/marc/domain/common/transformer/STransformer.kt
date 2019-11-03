package com.oliva.marc.domain.common.transformer

import io.reactivex.SingleTransformer

abstract class STransformer<T> : SingleTransformer<T, T>