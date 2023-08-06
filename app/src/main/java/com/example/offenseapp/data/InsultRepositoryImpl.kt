package com.example.offenseapp.data

import com.example.offenseapp.domain.model.InsultStructure
import com.example.offenseapp.domain.repository.InsultRepository

class InsultRepositoryImpl(private val client: RetrofitNetworkClient): InsultRepository{
    override fun loadInsult(): InsultStructure {
        val unknownStruct = client.doRequest("")
        if (unknownStruct.serverResponseCode==200) {
            return (unknownStruct as NetworkDataResponse<InsultStructure>).dataResponse!!
        }
        else return InsultStructure("test struct")
    }
}