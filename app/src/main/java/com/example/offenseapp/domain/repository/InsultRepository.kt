package com.example.offenseapp.domain.repository

import com.example.offenseapp.domain.model.InsultStructure

interface InsultRepository {
    fun loadInsult():InsultStructure
}