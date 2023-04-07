package com.example.history.data.repo

import com.example.history.data.model.HistoryItem

interface HistoryRepository {
    suspend fun getAllHistory(): List<HistoryItem>
    suspend fun getHistoryById(id: Int) : HistoryItem?
    suspend fun insert(item:HistoryItem)
    suspend fun delete(item:HistoryItem)
    suspend fun deleteAllHistory()
}