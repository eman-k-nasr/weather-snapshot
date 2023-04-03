package com.example.actions

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageInfo(val address:String,val date: String,val time: String): Parcelable
