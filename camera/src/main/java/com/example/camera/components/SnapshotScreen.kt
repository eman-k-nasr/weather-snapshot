package com.example.camera.components

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import com.example.actions.ImageInfo
import com.example.camera.R
import com.example.utils.IconTextButton

@Composable
fun SnapshotScreen(
    imageInfo: ImageInfo?,
    modifier: Modifier
){
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
                        imageInfo = imageInfo,
                        painter = rememberAsyncImagePainter(imageUri)
                    )

                    IconTextButton(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .align(Alignment.CenterHorizontally),
                        text = "Share it!!",
                        icon = Icons.Outlined.ThumbUp
                    ) {
                        shareImage()
                    }

                }else{
                    CameraLauncher(
                        onImageFile = { file ->
                            imageUri = file.toUri()
                        }
                    )
                }
            }else{
                ImageOverlay(
                    imageInfo = imageInfo,
                    painter = painterResource(id = R.drawable.black )
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        IconTextButton(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            text = "Take A Snapshot",
            icon = Icons.Filled.Camera
        ) {
            shouldShowPermission = true
        }
    }
}

fun shareImage() {

}
