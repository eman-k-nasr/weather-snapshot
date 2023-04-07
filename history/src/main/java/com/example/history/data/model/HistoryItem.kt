package com.example.history.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryItem(
    @PrimaryKey(autoGenerate = true)
    var itemId: Long = 0L,
    val imageUri: String = "",
    val address: String = "",
    val date: String = "",
    val time: String = "",
    val temperature: String = "",
    val status: String = "",
)
