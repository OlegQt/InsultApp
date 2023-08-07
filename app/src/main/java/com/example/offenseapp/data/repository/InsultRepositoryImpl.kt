package com.example.offenseapp.data.repository

import com.example.offenseapp.data.network.RetrofitNetworkClient
import com.example.offenseapp.data.dto.InsultLoadResponse
import com.example.offenseapp.domain.model.InsultStructure
import com.example.offenseapp.domain.repository.InsultRepository
import com.example.offenseapp.util.Resource

class InsultRepositoryImpl(private val client: RetrofitNetworkClient) : InsultRepository {
    override fun loadInsult(): Resource<InsultStructure> {
        val unknownStruct = client.doRequest("ru")
        return when (unknownStruct.serverResponseCode) {
            -1 -> Resource.Error(unknownStruct.serverResponseCode)
            200 -> Resource.Success(InsultStructure((unknownStruct as InsultLoadResponse).insult))
            else -> Resource.Error(unknownStruct.serverResponseCode)
        }

    }
}