package com.example.location.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GetLocationButton(
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
                    Icons.Filled.Map,
                    contentDescription = "location"
                )
            },
            text = { Text("Get Location") }
        )
    }
}