package com.example.teslivecodinglawencon.utils

sealed class Resouce<T>(
    val data: T? = null,
    val msg: String? = null
){
    class Success<T>(data: T) : Resouce<T>(data)
    class Loading<T>(data: T? = null) : Resouce<T>(data)
    class Error<T>(msg : String, data: T? = null) : Resouce<T>(data, msg)
}
