package com.example.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.model.HistoryItem

@Database(entities = [HistoryItem::class], version = 1, exportSchema = false)
abstract class HistoryDatabase: RoomDatabase() {
    abstract fun historyDao() : com.example.database.room.HistoryDao
}