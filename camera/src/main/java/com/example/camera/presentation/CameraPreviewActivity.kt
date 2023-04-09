package com.example.camera.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.actions.Actions.IMAGE_INFO
import com.example.actions.ImageInfo
import com.example.camera.components.*
import com.example.theme.WeatherSnapshotTheme
import com.example.utils.SnapshotTopbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraPreviewActivity : AppCompatActivity() {
    private val viewModel: CameraViewModel by viewModels()
    private var snapshotView: MutableState<SnapshotView>? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageInfo = intent.getParcelableExtra(IMAGE_INFO) as? ImageInfo

        setContent {
            WeatherSnapshotTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { SnapshotTopbar() },
                ) {
                    SnapshotScreen(
                        imageInfo = imageInfo,
                        snapshot = { info ->  Snapshot(info) },
                        modifier = Modifier
                            .padding(it)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        onImageCaptured = { item ->
                            viewModel.insertHistoryItem(item)
                        },
                        shareSnapshot = {
                            snapshotView?.value?.capture(snapshotView?.value as SnapshotView)
                        }
                    )
                }
            }
        }
    }

    @Composable
    fun Snapshot(imageInfo: ImageInfo?) {
        snapshotView = remember {
            mutableStateOf(
                SnapshotView(
                    context = this@CameraPreviewActivity,
                    imageInfo = imageInfo
                )
            )
        }
        AndroidView(modifier = Modifier.wrapContentSize(),
            factory = {
                SnapshotView(context = it, imageInfo = imageInfo).apply {
                    post {
                        snapshotView?.value = this
                    }
                }
            }
        )
    }
}