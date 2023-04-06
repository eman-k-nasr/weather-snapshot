package com.example.weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.remote.RequestState
import com.example.weather.data.repo.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
): ViewModel() {

    private val _uiState: MutableStateFlow<WeatherState> = MutableStateFlow(WeatherState())
    val uiState = _uiState.asStateFlow()

    suspend fun getCurrentWeather(lat: Double, long: Double): WeatherState {
       return viewModelScope.async {
           _uiState.update { it.copy(isLoading = true, error = null) }
           when(val result = repository.getCurrentWeather(lat, long)){
               is RequestState.Failure -> {
                   _uiState.update {
                       it.copy(
                           weatherData = null,
                           isLoading = false,
                           error = result.throwable.message
                       )
                   }
               }
               is RequestState.Success -> {
                   _uiState.update {
                       it.copy(
                           weatherData = result.data,
                           isLoading = false,
                           error = null
                       )
                   }
               }
           }
           return@async _uiState.value
       }.await()
    }
}