package com.lmmarketings.contexthypertext.data.json

import com.lmmarketings.contexthypertext.data.viewmodel.Result
import retrofit2.Response
import retrofit2.http.GET

interface GetApi{

    @GET("status/m")
    suspend fun getDatam():Response<Result>

    @GET("status/o")
    suspend fun getDatao():Response<Result>
}