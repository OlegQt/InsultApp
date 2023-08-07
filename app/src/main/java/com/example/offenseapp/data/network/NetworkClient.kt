package com.example.offenseapp.data.network

import com.example.offenseapp.data.dto.NetworkResponse

interface NetworkClient {
    fun doRequest(params: Any): NetworkResponse
}