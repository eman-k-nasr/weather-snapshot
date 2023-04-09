package com.example.camera.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AbstractComposeView
import coil.compose.rememberAsyncImagePainter
import com.example.actions.ImageInfo
import com.example.camera.getViewAsBitmap
import com.example.camera.share

@SuppressLint("ViewConstructor")
class SnapshotView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    private val imageInfo: ImageInfo?,
) : AbstractComposeView(context, attrs, defStyleAttr) {


    @Composable
    override fun Content() {
        ImageOverlay(
            imageInfo = imageInfo,
            painter = rememberAsyncImagePainter(imageInfo?.imageUri)
        )
    }

    fun capture(view: SnapshotView,text: String = "Look my snapshot !!") {
        val bitmap = view.getViewAsBitmap(context as Activity)
        bitmap.share(context = context,text = text)
    }

}