package com.example.weathersnapshot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.actions.Actions
import com.example.actions.ImageInfo
import com.example.weathersnapshot.ui.theme.WeatherSnapshotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherSnapshotTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Greeting("Android")
                        Button(onClick = {
                            startActivity(
                                Actions.openCameraActivity(
                                    context = this@MainActivity,
                                    imageInfo = ImageInfo(address = "cairo",date = "4-3-2023", time = "10:00 pm")
                                )
                            )
                        }) {
                            Text(text = "open camera")
                        }
                        Button(onClick = {
                            startActivity(
                                Actions.openAccessLocationActivity(this@MainActivity)
                            )
                        }) {
                            Text(text = "access location")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherSnapshotTheme {
        Greeting("Android")
    }
}