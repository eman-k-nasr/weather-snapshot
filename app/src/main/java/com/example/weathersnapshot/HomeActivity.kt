package com.example.weathersnapshot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.actions.Actions
import com.example.actions.ImageInfo
import com.example.theme.WeatherSnapshotTheme
import com.example.weathersnapshot.components.StartScreen

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherSnapshotTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    StartScreen(modifier = Modifier.padding(16.dp)) {
                        startActivity(
                            Actions.openWeatherActivity(context = this)
                        )
                    }
//                    Column(modifier = Modifier.padding(16.dp)) {
//                        Button(onClick = {
//                            startActivity(
//                                Actions.openCameraActivity(
//                                    context = this@HomeActivity,
//                                    imageInfo = ImageInfo(address = "cairo",date = "4-3-2023", time = "10:00 pm")
//                                )
//                            )
//                        }) {
//                            Text(text = "Take a snapshot")
//                        }
//                    }
                }
            }
        }
    }
}