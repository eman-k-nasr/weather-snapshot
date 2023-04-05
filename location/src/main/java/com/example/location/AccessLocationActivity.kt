package com.example.location

import android.annotation.SuppressLint
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.example.location.components.LocationScreen
import com.example.theme.WeatherSnapshotTheme
import com.example.utils.SnapshotTopbar
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class AccessLocationActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        setContent {
            WeatherSnapshotTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { SnapshotTopbar() },
                ) {
                    LocationScreen(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        getCurrentLocation = { getCurrentLocation() }
                    )
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun getCurrentLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->
               Log.d("CurrentLocation","location info lat:${location?.latitude}, long:${location?.longitude}")
            }
    }
}