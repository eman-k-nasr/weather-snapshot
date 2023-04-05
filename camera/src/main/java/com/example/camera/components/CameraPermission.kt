package com.example.camera.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.utils.Permission

@Composable
fun CameraPermission(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = { }
) {
    Permission(
        permission = android.Manifest.permission.CAMERA,
        rationale = "We want access to your camera to be able to take photo :)",
    ) {
        content.invoke()
    }
}