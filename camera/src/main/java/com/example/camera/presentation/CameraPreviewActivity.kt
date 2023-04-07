package com.example.camera.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.example.actions.Actions.IMAGE_INFO
import com.example.actions.ImageInfo
import com.example.camera.components.*
import com.example.theme.WeatherSnapshotTheme
import com.example.utils.SnapshotTopbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraPreviewActivity : AppCompatActivity() {
    private val viewModel: CameraViewModel by viewModels()

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
                        modifier = Modifier
                            .padding(it)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        onImageCaptured = { item ->
                            viewModel.insertHistoryItem(item)
                        }
                    )
                }
            }
        }
    }
}