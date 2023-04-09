package com.example.actions

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageInfo(
    val address: String = "Monshaat Nasir",
    val date: String = "3 April",
    val time: String = "10:36",
    val temperature: String = "22 c",
    val status: String = "Clear",
    val imageUri: String? = ""
) : Parcelable
