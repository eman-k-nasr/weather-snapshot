package com.example.camera.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SnapShotButton(
    modifier: Modifier,
    onClick: () -> Unit ,
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
                    Icons.Filled.Camera,
                    contentDescription = "snapshot"
                )
            },
            text = { Text("Take A Snapshot") }
        )
    }
}