package com.carl.cathay_test.model

import android.content.Context
import com.carl.cathay_test.http.ApiMgr
import com.carl.cathay_test.http.httpCallBack.ApiCallBack

class ApiGetZoo(val context: Context) {

    fun call(scope: String, q: String?, limit: Int?, offset: Int?, back: ((ResZoo) -> Unit)) {

        ApiMgr.getInstance().getApiZoo(scope, q, limit, offset, object : ApiCallBack<ResZoo>() {
            override fun initCallback() {

            }

            override fun onSuccess(bean: ResZoo) {
                back.invoke(bean)
            }

            override fun onFail(bean: ResZoo) {

            }

            override fun onFail() {

            }

            override fun onComplete() {

            }

            override fun tokenRefresh() {}
        })
    }
}