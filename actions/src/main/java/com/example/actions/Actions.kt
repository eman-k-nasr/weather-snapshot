package com.example.actions

import android.content.Context
import android.content.Intent

object Actions {
    fun openWeatherActivity(context: Context) =
        internalIntent(context = context, action = "action.WeatherActivity.open")

    fun openCameraActivity(context: Context,imageInfo: ImageInfo) =
        internalIntent(context = context, action = "action.CameraPreviewActivity.open")
            .putExtra(IMAGE_INFO,imageInfo)

    fun openAccessLocationActivity(context: Context) =
        internalIntent(context = context, action = "action.AccessLocationActivity.open")

    private fun internalIntent(context: Context, action: String) =
        Intent(action).setPackage(context.packageName)

    const val IMAGE_INFO = "image_info"
    const val LATITUDE = "latitude"
    const val LONGITUDE = "longitude"
}