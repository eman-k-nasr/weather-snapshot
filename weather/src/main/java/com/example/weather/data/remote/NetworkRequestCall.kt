package com.example.weather.data.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface NetworkRequestCall{
    val dispatcher: CoroutineDispatcher
}

suspend fun <T> NetworkRequestCall.request(apiCall: suspend () -> T): RequestState<T> =
    withContext(dispatcher) {
        try {
            RequestState.Success(apiCall.invoke())
        } catch (throwable: Exception) {
            RequestState.Failure(throwable)
        }
    }