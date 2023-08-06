package com.example.offenseapp.domain.usecase

import com.example.offenseapp.domain.model.InsultStructure
import com.example.offenseapp.domain.repository.InsultRepository

class LoadInsultUseCase(private val repository: InsultRepository) {
    fun consume():InsultStructure{
        return repository.loadInsult()
    }
}