package com.lmmarketings.contexthypertext.data.json

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{

    val getApi = retrofit().create(GetApi::class.java)

    val postsApi = retrofit().create(PostApi::class.java)

    private fun retrofit() = Retrofit.Builder()
        .baseUrl("https://context-hypertext.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}