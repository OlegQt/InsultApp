package com.example.offenseapp.domain.repository

import com.example.offenseapp.domain.model.InsultStructure
import com.example.offenseapp.util.Resource

interface InsultRepository {
    fun loadInsult(): Resource<InsultStructure>
}