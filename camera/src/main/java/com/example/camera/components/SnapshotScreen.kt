package com.example.camera.components

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.actions.ImageInfo
import com.example.camera.R
import com.example.database.model.HistoryItem
import com.example.utils.IconTextButton

@Composable
fun SnapshotScreen(
    snapshot: @Composable (ImageInfo) -> Unit,
    imageInfo: ImageInfo?,
    modifier: Modifier,
    onImageCaptured: (HistoryItem) -> Unit,
    shareSnapshot: (ImageInfo) -> Unit,
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
                    Log.d("snapshot","image uri : $imageUri")

                    imageInfo?.let {
                        snapshot.invoke(imageInfo.copy(imageUri = imageUri.toString()))
                        onImageCaptured.invoke(
                            HistoryItem(
                                imageUri = imageUri.toString(),
                                address = it.address,
                                date = it.date,
                                time = it.time,
                                temperature = it.temperature,
                                status = it.status
                            )
                        )
                    }

                    IconTextButton(
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .align(Alignment.CenterHorizontally),
                        text = "Share it!!",
                        icon = Icons.Outlined.Share
                    ) {
                        imageInfo?.let {
                            shareSnapshot.invoke(it.copy(imageUri = imageUri.toString()))
                        }
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
