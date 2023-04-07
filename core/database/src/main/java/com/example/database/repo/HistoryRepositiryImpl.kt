package com.example.database.repo

import com.example.database.room.HistoryDatabase
import com.example.database.model.HistoryItem
import javax.inject.Inject

class HistoryRepositiryImpl @Inject constructor(
    private val historyDatabase: HistoryDatabase
) : com.example.database.repo.HistoryRepository {
    override suspend fun getAllHistory(): List<HistoryItem> {
        return historyDatabase.historyDao().getAllHistory()
    }

    override suspend fun getHistoryById(id: Int): HistoryItem? {
        return historyDatabase.historyDao().getHistoryById(id)
    }

    override suspend fun insert(item: HistoryItem) {
        historyDatabase.historyDao().insert(item)
    }

    override suspend fun delete(item: HistoryItem) {
        historyDatabase.historyDao().delete(item)
    }

    override suspend fun deleteAllHistory() {
        historyDatabase.historyDao().deleteAllHistory()
    }
}