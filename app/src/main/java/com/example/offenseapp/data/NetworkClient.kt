package com.example.offenseapp.data

import retrofit2.Response

interface NetworkClient {
    fun doRequest(params:Any):NetworkResponse
}