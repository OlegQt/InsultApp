package com.example.offenseapp.domain.usecase

import android.util.Log
import com.example.offenseapp.domain.model.InsultStructure
import com.example.offenseapp.domain.repository.InsultRepository

class LoadInsultUseCase(private val repository: InsultRepository) {
    fun execute(consumer: Consumer) {
        val thread = Thread({
            try {
                val newInsult = repository.loadInsult()
                consumer.consume(newInsult)
            } catch (e: Throwable) {
                Log.e("Some",e.toString())
            }
        }, "InsultRequest")
        thread.start()
    }

    fun interface Consumer {
        fun consume(insult: InsultStructure)
    }
}