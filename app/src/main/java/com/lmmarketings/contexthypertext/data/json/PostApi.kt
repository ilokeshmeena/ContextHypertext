package com.lmmarketings.contexthypertext.data.json

import retrofit2.Call
import retrofit2.http.POST
import com.lmmarketings.contexthypertext.data.viewmodel.ResultX
import retrofit2.Response
import retrofit2.http.Body


interface PostApi{

    @POST("status/add")
    suspend fun addNewData(@Body body:ResultX):Postresponse



}