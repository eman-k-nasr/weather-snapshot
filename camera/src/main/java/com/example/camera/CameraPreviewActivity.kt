package com.example.camera

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.actions.Actions.IMAGE_INFO
import com.example.actions.ImageInfo

class CameraPreviewActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_preview)
        val infoTv:TextView = findViewById(R.id.infoTv)
        val imageInfo = intent.getParcelableExtra(IMAGE_INFO) as? ImageInfo
        infoTv.text = "${imageInfo?.address}, ${imageInfo?.date} ,${imageInfo?.time}"
    }
}