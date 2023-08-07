package com.example.offenseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import com.example.offenseapp.data.repository.InsultRepositoryImpl
import com.example.offenseapp.data.network.RetrofitNetworkClient
import com.example.offenseapp.domain.usecase.LoadInsultUseCase
import com.example.offenseapp.util.Resource
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())
    private val repo = InsultRepositoryImpl(RetrofitNetworkClient())
    private val useCase = LoadInsultUseCase(repository = repo)

    lateinit var txt: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById<TextView>(R.id.insult_text)

        val btn = findViewById<Button>(R.id.btn_action)
        btn.setOnClickListener { loadNewInsult() }
    }

    private fun loadNewInsult() {
        useCase.execute() {
            when (it) {
                is Resource.Success -> {
                    handler.post {
                        txt.text = it.data?.insult.toString()
                    }
                }

                else -> {}
            }
        }
    }
}