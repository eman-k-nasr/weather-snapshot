package com.example.weather.components

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.weather.presentation.WeatherState

@Composable
fun WeatherErrorCard(
    modifier: Modifier = Modifier,
    state: WeatherState,
){
    if(state.isLoading){
        CircularProgressIndicator(modifier = modifier)
    }

    state.error?.let {
        Text(
            modifier = modifier,
            text = it,
            color = Color.Red,
            textAlign = TextAlign.Center,
        )
    }
}