package com.example.weather.data.repo

import com.example.utils.DateFormat.getDateString
import com.example.weather.data.di.IoDispatcher
import com.example.weather.data.model.WeatherData
import com.example.weather.data.remote.NetworkRequestCall
import com.example.weather.data.remote.RequestState
import com.example.weather.data.remote.api.OpenWeatherApi
import com.example.weather.data.remote.request
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val weatherService : OpenWeatherApi,
    @IoDispatcher override val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    ): WeatherRepository,NetworkRequestCall{

    override suspend fun getCurrentWeather(lat: Double, long: Double): RequestState<WeatherData> {
        return request {
            val response = weatherService.getCurrentWeather(lat, long)
            WeatherData(
                status = response.weather.first().status,
                temperature = "${response.weatherInfo.temp} °C",
                date = getDateString(response.timestamp).substringBefore(","),
                time = getDateString(response.timestamp).substringAfter(","),
                city = response.name
            )
        }
    }

}
