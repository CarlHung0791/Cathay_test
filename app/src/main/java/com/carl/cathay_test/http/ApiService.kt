package com.carl.cathay_test.http

import com.carl.cathay_test.model.ResPlant
import com.carl.cathay_test.model.ResZoo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
    fun getZoo(
        @Query("scope") scope: String,
        @Query("q") q: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Call<ResZoo>

    @GET("api/v1/dataset/f18de02f-b6c9-47c0-8cda-50efad621c14")
    fun getPlant(
        @Query("scope") scope: String,
        @Query("q") q: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): Call<ResPlant>
}