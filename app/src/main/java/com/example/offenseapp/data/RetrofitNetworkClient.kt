package com.example.offenseapp.data

import com.example.offenseapp.Offense
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RetrofitNetworkClient:NetworkClient {
    override fun doRequest(params: Any): NetworkResponse {

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://evilinsult.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(InsultApi::class.java)
        val response = service.getOffence().execute()
        val body = response.body()
        return NetworkResponse.RequestSuccess(body)
    }
}

interface InsultApi{
    @GET("/generate_insult.php?type=json")
    fun getOffence() : Call<Offense>
}