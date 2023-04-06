package com.example.weather.data.remote.api

import com.example.weather.data.model.response.WeatherResponse
import com.example.weather.data.remote.api.Endpoints.API_KEY
import com.example.weather.data.remote.api.Endpoints.APP_ID
import com.example.weather.data.remote.api.Endpoints.LAT
import com.example.weather.data.remote.api.Endpoints.LONG
import com.example.weather.data.remote.api.Endpoints.UNIT
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query(LAT) lat : Double,
        @Query(LONG) long: Double,
        @Query(UNIT) unit: String = "metric",
        @Query(APP_ID) appId: String = API_KEY
    ): WeatherResponse
}