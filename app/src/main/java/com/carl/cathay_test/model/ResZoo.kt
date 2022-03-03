package com.carl.cathay_test.model

data class ResZoo(
    val result: ResultDataZoo
)

data class ResultDataZoo(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: MutableList<ResultZoo> = ArrayList(),
    val sort: String
)

data class ResultZoo(
    val E_Category: String,
    val E_Geo: String,
    val E_Info: String,
    val E_Memo: String,
    val E_Name: String,
    val E_Pic_URL: String,
    val E_URL: String,
    val E_no: String,
    val _id: Int
)