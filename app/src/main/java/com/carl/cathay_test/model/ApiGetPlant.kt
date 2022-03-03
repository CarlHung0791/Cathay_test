package com.carl.cathay_test.model

import android.content.Context
import android.util.Log
import com.carl.cathay_test.http.ApiMgr
import com.carl.cathay_test.http.httpCallBack.ApiCallBack
import com.google.gson.Gson

class ApiGetPlant(val context: Context) {

    fun call(scope: String, q: String?, limit: Int?, offset: Int?, back: ((ResPlant) -> Unit)) {

        ApiMgr.getInstance().getPlant(scope, q, limit, offset, object : ApiCallBack<ResPlant>() {
            override fun initCallback() {

            }

            override fun onSuccess(bean: ResPlant) {
                back.invoke(bean)
            }

            override fun onFail(bean: ResPlant) {

            }

            override fun onFail() {

            }

            override fun onComplete() {

            }

            override fun tokenRefresh() {}
        })
    }
}