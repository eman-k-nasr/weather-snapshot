package com.example.weather

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.actions.Actions
import com.example.actions.ImageInfo
import com.example.theme.WeatherSnapshotTheme
import com.example.utils.SnapshotTopbar
import com.example.weather.components.WeatherScreen
import com.example.weather.presentation.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resumeWithException

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        setContent {
            val coroutineScope = rememberCoroutineScope()
            WeatherSnapshotTheme{
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { SnapshotTopbar() },
                ) {
                    WeatherScreen(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        getCurrentLocation = {
                            coroutineScope.launch {
                                getCurrentLocation()?.let { location ->
                                    getCurrentWeather(location)
                                }
                            }
                        }
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @SuppressLint("MissingPermission")
    suspend fun getCurrentLocation(): Location? {
        return suspendCancellableCoroutine { cont->
            fusedLocationClient.lastLocation.apply {
                if(isComplete) {
                    if(isSuccessful) {
                        cont.resume(this.result,onCancellation = null)
                    }
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener {
                    cont.resume(it,null)
                }
                addOnFailureListener {
                    cont.resumeWithException(it)
                }
                addOnCanceledListener {
                    cont.cancel()
                }
            }
        }
    }

    private suspend fun getCurrentWeather(location: Location){
        val state  = viewModel.getCurrentWeather(lat = location.latitude, long = location.longitude)
        state.weatherData?.let { weather ->
            startActivity(
                Actions.openCameraActivity(
                    context = this@WeatherActivity,
                    imageInfo = ImageInfo(
                        address = weather.city,
                        temperature = weather.temperature,
                        status = weather.status,
                        date = weather.date,
                        time = weather.time
                    )
                )
            )
        }

        state.error?.let { err->
            Toast.makeText(this@WeatherActivity,err,Toast.LENGTH_LONG).show()
        }
    }
}