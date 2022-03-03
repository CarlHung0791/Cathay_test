package com.carl.cathay_test.http.httpCallBack

import retrofit2.Callback

interface BaseCallBack<T> {
    fun getCallback(var1: ApiCallBack<T>?): Callback<T>?
}