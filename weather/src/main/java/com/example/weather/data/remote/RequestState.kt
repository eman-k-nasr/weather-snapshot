package com.example.weather.data.remote

sealed class RequestState<out T> {
    data class Success<out T>(val data: T) : RequestState<T>() {
        fun get(): T = data
    }

    data class Failure(val throwable: Exception) : RequestState<Nothing>()
}