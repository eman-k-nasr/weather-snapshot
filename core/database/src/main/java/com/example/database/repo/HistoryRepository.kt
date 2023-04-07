package com.example.database.repo

import com.example.database.model.HistoryItem


interface HistoryRepository {
    suspend fun getAllHistory(): List<HistoryItem>
    suspend fun getHistoryById(id: Int) : HistoryItem?
    suspend fun insert(item: HistoryItem)
    suspend fun delete(item: HistoryItem)
    suspend fun deleteAllHistory()
}