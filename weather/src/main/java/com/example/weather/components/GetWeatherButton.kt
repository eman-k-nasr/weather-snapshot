package com.example.weather.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GetWeatherButton(
    modifier: Modifier,
    onClick:  () -> Unit,
){
    Row(
        modifier = modifier
    ) {
        ExtendedFloatingActionButton(
            onClick = {
                onClick.invoke()
            },
            icon = {
                Icon(
                    Icons.Filled.Cloud,
                    contentDescription = "weather"
                )
            },
            text = { Text("Know Weather") }
        )
    }
}