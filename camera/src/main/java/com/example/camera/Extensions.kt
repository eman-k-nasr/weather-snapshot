package com.example.camera

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.PixelCopy
import android.view.View
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executor
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun Bitmap.save(context: Context): Uri? {
    val path: String = context.externalCacheDir.toString() + "/screenshot.jpg"
    val out: OutputStream?
    val file = File(path)
    try {
        out = FileOutputStream(file)
        compress(Bitmap.CompressFormat.JPEG, 100, out)
        out.flush()
        out.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return FileProvider.getUriForFile(
        context, context.packageName + ".weathersnapshot-provider.provider", file
    )
}

fun Bitmap?.share(context: Context, text: String?) {
    val imageUri: Uri? = this?.let { save(context) }
    val chooserIntent = Intent(Intent.ACTION_SEND)
    chooserIntent.type = "image/*"
    chooserIntent.putExtra(Intent.EXTRA_TEXT, text)
    chooserIntent.putExtra(Intent.EXTRA_STREAM, imageUri)
    chooserIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    try {
        context.startActivity(chooserIntent)
    } catch (ex: Exception) {
        Log.e("Bitmap","$ex")
    }
}

fun View.getViewAsBitmap(activity: Activity): Bitmap {
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val locations = IntArray(2)
        getLocationInWindow(locations)
        val rect = Rect(
            locations[0],
            locations[1], locations[0] + width, locations[1] + height
        )
        PixelCopy.request(
            activity.window,
            rect,
            bitmap,
            {},
            Handler(Looper.getMainLooper())
        )
    } else {
        val canvas = Canvas(bitmap)
        layout(left, top, right, bottom)
        draw(canvas)
    }
    return bitmap
}

suspend fun Context.getCameraProvider(): ProcessCameraProvider = suspendCoroutine { continuation ->
    ProcessCameraProvider.getInstance(this).also { future ->
        future.addListener(
            {
                continuation.resume(future.get())
            },
            executor
        )
    }
}

val Context.executor: Executor
    get() = ContextCompat.getMainExecutor(this)

@SuppressLint("SimpleDateFormat")
suspend fun ImageCapture.takePicture(context:Context, executor: Executor): File {

    val photoFile = withContext(Dispatchers.IO) {
        kotlin.runCatching {
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            File.createTempFile(
                "JPEG_${timeStamp}_", //prefix
                ".jpg", //suffix
                storageDir //directory
            )
        }.getOrElse { ex ->
            Log.e("TakePicture", "Failed to create temporary file", ex)
            File("/dev/null")
        }
    }

    return suspendCoroutine { continuation ->
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
        Log.d("TakePicture", "Image file path $photoFile")
        takePicture(
            outputOptions, executor,
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    Log.d("TakePicture", "Image Saved")
                    continuation.resume(photoFile)
                }

                override fun onError(ex: ImageCaptureException) {
                    Log.e("TakePicture", "Image capture failed", ex)
                    continuation.resumeWithException(ex)
                }
            }
        )
    }
}