package com.example.history.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.history.data.model.HistoryItem

@Dao
interface HistoryDao {
    @Query("SELECT * from history")
    suspend fun getAllHistory(): List<HistoryItem>

    @Query("SELECT * from history where itemId = :id")
    suspend fun getHistoryById(id: Int) : HistoryItem?

    @Insert
    suspend fun insert(item:HistoryItem)

    @Delete
    suspend fun delete(item:HistoryItem)

    @Query("DELETE FROM history")
    suspend fun deleteAllHistory()
}