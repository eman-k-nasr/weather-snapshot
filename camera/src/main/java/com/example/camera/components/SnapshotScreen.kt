package com.example.camera.components

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import com.example.actions.ImageInfo
import com.example.camera.R

@Composable
fun SnapshotScreen(modifier: Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var shouldShowPermission by remember { mutableStateOf(false) }
        val emptyImageUri = Uri.parse("file://dev/null")
        var imageUri by remember { mutableStateOf(emptyImageUri) }

        Column{
            if(shouldShowPermission){
                if(imageUri != emptyImageUri){
                    ImageOverlay(
                        imageInfo = ImageInfo(),
                        painter = rememberAsyncImagePainter(imageUri)
                    )
                }else{
                    Snapshot(
                        onImageFile = { file ->
                            imageUri = file.toUri()
                        }
                    )
                }
            }else{
                ImageOverlay(
                    imageInfo = ImageInfo(),
                    painter = painterResource(id = R.drawable.black )
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        SnapShotButton(modifier = Modifier
            .padding(bottom = 16.dp)
            .align(Alignment.CenterHorizontally)
        ) {
            shouldShowPermission = true
        }
    }
}