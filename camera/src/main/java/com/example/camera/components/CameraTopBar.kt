package com.example.camera.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.utils.TopBar

@Composable
fun CameraTopBar(
    modifier: Modifier = Modifier
){
    TopBar(modifier = modifier, title = "Snapshot", backIcon = null)
}