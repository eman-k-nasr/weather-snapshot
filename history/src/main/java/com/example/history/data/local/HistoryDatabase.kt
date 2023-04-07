package com.example.history.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.history.data.model.HistoryItem

@Database(entities = [HistoryItem::class], version = 1, exportSchema = false)
abstract class HistoryDatabase: RoomDatabase() {
    abstract fun historyDao() : HistoryDao
}