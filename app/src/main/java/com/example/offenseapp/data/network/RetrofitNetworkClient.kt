package com.example.offenseapp.data.network

import com.example.offenseapp.data.dto.NetworkResponse
import com.example.offenseapp.data.dto.InsultLoadResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RetrofitNetworkClient : NetworkClient {
    override fun doRequest(params: Any): NetworkResponse {

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://evilinsult.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(InsultApi::class.java)

        val response = service.getOffence("ru").execute()
        val body = response.body()

        if (body != null) return body.apply { serverResponseCode = response.code() }
        else return NetworkResponse().apply { serverResponseCode = response.code() }
    }
}

interface InsultApi {
    @GET("/generate_insult.php?type=json")
    fun getOffence(@Query("lang") lang:String): Call<InsultLoadResponse>
}