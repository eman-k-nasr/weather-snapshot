package com.example.weather.data.model.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val weather: List<Weather>,
    @SerializedName("main")
    val weatherInfo: WeatherInfo,
    val coord: Coord,
    @SerializedName("dt")
    val timestamp: Long,
    val id: Int,
    val name: String,
    val timezone: Int,
    val wind: Wind
)