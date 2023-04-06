package com.example.camera.components

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun CameraLauncher(
    modifier: Modifier = Modifier,
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA,
    onImageFile: (File) -> Unit = { }
){
    CameraPermission(
        modifier = Modifier.fillMaxSize(),
        content = {
            CameraCapturePreview(modifier, cameraSelector, onImageFile)
        }
    )
}