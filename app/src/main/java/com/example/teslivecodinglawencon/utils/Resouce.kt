package com.example.teslivecodinglawencon.utils

sealed class Resouce<T>(
    val data: T? = null,
    val msg: String? = null
){
    class SUCESS<T>(data: T) : Resouce<T>(data)
    class LOAD<T>(data: T? = null) : Resouce<T>(data)
    class ERROR<T>(msg : String, data: T? = null) : Resouce<T>(data, msg)
}
