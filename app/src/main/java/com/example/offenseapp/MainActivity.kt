package com.example.offenseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit:RetrofitClient = RetrofitClient()
        retrofit.doRequest()
    }
}data class Offense(
    val insult: String

)

interface OffenseApi{
    @GET("/generate_insult.php?type=json")
    fun getOffence() :Call<Offense>
}
class RetrofitClient(){
    private val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://evilinsult.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: OffenseApi = retrofit.create(OffenseApi::class.java)

    fun doRequest(){
        val response = service.getOffence().enqueue(object :Callback<Offense>{
            override fun onResponse(call: Call<Offense>, response: Response<Offense>) {
                //TODO("Not yet implemented")
                if (response.isSuccessful){
                    val body = response.body()
                    Log.e("Some","${body?.insult}")

                }

                Log.e("Some",response.code().toString())
            }

            override fun onFailure(call: Call<Offense>, t: Throwable) {
                //TODO("Not yet implemented")
                Log.e("Some",t.toString())
            }
        })
    }
}