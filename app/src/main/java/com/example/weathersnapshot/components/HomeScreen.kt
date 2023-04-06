package com.example.weathersnapshot.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    takeSnapshot: () -> Unit,
    viewHistory: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            modifier = Modifier.width(200.dp).align(Alignment.CenterHorizontally),
            onClick = {
                takeSnapshot.invoke()
            }) {
            Text(text = "Take a snapshot")
        }

        Button(
            modifier = Modifier.width(200.dp).align(Alignment.CenterHorizontally),
            onClick = {
               viewHistory.invoke()
            }) {
            Text(text = "View History")
        }
    }
}