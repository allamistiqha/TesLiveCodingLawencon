package com.example.teslivecodinglawencon.utils

import kotlinx.coroutines.flow.*

inline fun <Result, Request> networkBoundResouce (
        crossinline query: ()-> Flow<Result>,
        crossinline fetch: suspend ()-> Request,
        crossinline saveFetchResult: suspend (Request)-> Unit,
        crossinline shouldFetch: (Result) -> Boolean = { true }
 ) = flow {
    val data = query().first()
    val flow = if(shouldFetch(data)){
        emit(Resouce.Loading(data))
        try {
            saveFetchResult(fetch())
            query().map { Resouce.Success(it) }
        }catch (e : Throwable){
            query().map { Resouce.Error(e.message.toString(), it) }
        }
    }else{
        query().map {
            Resouce.Success(it)
        }
    }

    emitAll(flow)
}