package com.example.weather.data.repo

import com.example.weather.data.model.WeatherData
import com.example.weather.data.remote.RequestState

interface WeatherRepository {
    suspend fun getCurrentWeather(lat: Double, long: Double) : RequestState<WeatherData>
}