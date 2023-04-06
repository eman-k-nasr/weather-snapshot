package com.example.weather.components

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.utils.Permission

@Composable
fun LocationPermission(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = { }
) {
    Permission(
        permission =  Manifest.permission.ACCESS_FINE_LOCATION,
        rationale = "We want access to your location ",
    ) {
        content.invoke()
    }
}