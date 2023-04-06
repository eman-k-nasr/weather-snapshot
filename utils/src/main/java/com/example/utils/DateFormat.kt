package com.example.utils

import java.text.SimpleDateFormat
import java.util.*

object DateFormat{
    private val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy,HH:mm", Locale.ENGLISH)
    fun getDateString(time: Long) : String = simpleDateFormat.format(time * 1000L)
}
