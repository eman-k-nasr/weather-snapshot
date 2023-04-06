package com.example.utils

import androidx.compose.foundation.layout.Row
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconTextButton(
    modifier: Modifier,
    text: String,
    icon: ImageVector,
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
                    imageVector = icon,
                    contentDescription = "icon"
                )
            },
            text = { Text(text = text) }
        )
    }
}