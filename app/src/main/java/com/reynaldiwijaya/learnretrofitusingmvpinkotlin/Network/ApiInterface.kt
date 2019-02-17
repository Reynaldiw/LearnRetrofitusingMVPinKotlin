package com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Network

import com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Model.ResponseLogin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInterface {

    fun create(): ApiClient {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://reqres.in/")
            .build()

        return retrofit.create(ApiClient::class.java)
    }
}