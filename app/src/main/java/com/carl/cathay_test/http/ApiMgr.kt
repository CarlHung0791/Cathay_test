package com.carl.cathay_test.http

import com.carl.cathay_test.http.httpCallBack.ApiCallBack
import com.carl.cathay_test.http.httpCallBack.BaseCallBack
import com.carl.cathay_test.model.ResPlant
import com.carl.cathay_test.model.ResZoo
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiMgr {

    var retrofit: Retrofit
    var apiService: ApiService

    companion object {
        @Volatile
        private var instance: ApiMgr? = null
        fun getInstance(): ApiMgr {
            if (instance == null) {
                synchronized(ApiMgr::class) {
                    if (instance == null) {
                        instance = ApiMgr()
                    }
                }
            }
            return instance!!
        }
    }

    init {
        val client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(0, 1, TimeUnit.SECONDS))
            .build()
        retrofit =
            Retrofit.Builder().baseUrl("https://data.taipei").client(client).addConverterFactory(
                GsonConverterFactory.create()
            ).build()
        apiService = retrofit.create(ApiService::class.java)
    }


    fun getApiZoo(scope:String,q:String?,limit:Int?,offset:Int?,call: ApiCallBack<ResZoo>){
        apiService.getZoo(scope,q,limit,offset).enqueue(InitCallBack<ResZoo>().getCallback(call))
    }

    fun getPlant(scope:String,q:String?,limit:Int?,offset:Int?,call: ApiCallBack<ResPlant>){
        apiService.getPlant(scope,q,limit,offset).enqueue(InitCallBack<ResPlant>().getCallback(call))
    }


    open class InitCallBack<T> : BaseCallBack<T> {
        override fun getCallback(var1: ApiCallBack<T>?): Callback<T> {

            var1?.initCallback()
            return object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    when {
                        response.code() == 401 -> {

                        }
                        response.isSuccessful && response.code() == 200 -> {
                            var1?.onSuccess(response.body()!!)
                        }
                        else -> {
                            var1?.onFail()
                        }
                    }
                    var1?.onComplete()
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    var1?.onFail()
                    var1?.onComplete()
                }
            }
        }



    }
}