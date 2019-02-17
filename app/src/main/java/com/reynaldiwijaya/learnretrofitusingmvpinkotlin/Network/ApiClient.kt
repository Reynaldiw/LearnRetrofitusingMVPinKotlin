package com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Network

import com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Model.LoginBody
import com.reynaldiwijaya.learnretrofitusingmvpinkotlin.Model.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiClient {

    @POST("/api/login")
    fun doLogin(@Body loginBody : LoginBody) : Call<ResponseLogin>
}