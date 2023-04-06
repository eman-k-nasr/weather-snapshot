package com.example.weathersnapshot.components

import androidx.compose.runtime.Composable

@Composable
fun HistoryScreen(
    onGetStartClicked: () -> Unit
){
    EmptyScreen(
        onClick = onGetStartClicked
    )
}