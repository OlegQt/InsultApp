package com.example.offenseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.offenseapp.data.InsultRepositoryImpl
import com.example.offenseapp.data.RetrofitNetworkClient
import com.example.offenseapp.domain.usecase.LoadInsultUseCase
import com.google.android.material.snackbar.Snackbar
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {
    val handler = Handler(Looper.getMainLooper())
    val repo = InsultRepositoryImpl(RetrofitNetworkClient())
    val useCase = LoadInsultUseCase(repository = repo)

    lateinit var txt:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById<TextView>(R.id.insult_text)

        val btn = findViewById<Button>(R.id.btn_action)
        btn.setOnClickListener {
            loadNewInsult()
            Snackbar.make(txt,"kdkkd",Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun loadNewInsult(){
        useCase.execute() {
            handler.post {
                Log.e("Some", it.insult.toString())
                txt.text = it.insult.toString()
            }
        }
    }
}