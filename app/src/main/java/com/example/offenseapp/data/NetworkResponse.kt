package com.example.offenseapp.data

sealed class NetworkResponse{
    class RequestFail(val errorCode:Int): NetworkResponse()
    class RequestSuccess(val data:Any?):NetworkResponse()
}
