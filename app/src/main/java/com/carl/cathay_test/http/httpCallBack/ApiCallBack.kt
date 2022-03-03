package com.carl.cathay_test.http.httpCallBack

open class ApiCallBack<T> : HttpCallBack<T> {
    override fun initCallback() {
    }

    override fun onSuccess(bean: T) {
    }

    override fun onFail(bean: T) {
    }

    override fun onFail() {
    }

    override fun onComplete() {

    }

    override fun tokenRefresh() {

    }
}