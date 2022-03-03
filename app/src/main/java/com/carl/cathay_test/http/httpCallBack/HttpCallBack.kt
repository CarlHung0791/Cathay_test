package com.carl.cathay_test.http.httpCallBack

interface HttpCallBack<T> {

    fun initCallback()
    fun onSuccess(bean: T)
    fun onFail(bean: T)
    fun onFail()
    fun onComplete()
    fun tokenRefresh()

}