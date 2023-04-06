package com.example.weathersnapshot.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GetStartButton(
    modifier: Modifier,
    onClick: () -> Unit,
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
                    Icons.Outlined.ThumbUp,
                    contentDescription = "start"
                )
            },
            text = { Text("Get Started") }
        )
    }
}