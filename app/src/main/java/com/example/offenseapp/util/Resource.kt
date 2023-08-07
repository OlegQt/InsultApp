package com.example.offenseapp.util

sealed class Resource<T>(val data:T?,val code:Int?){
    class Error<T>(code: Int):Resource<T>(null,code)
    class Success<T>(data: T):Resource<T>(data,null)
}
