package com.example.history.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.database.model.HistoryItem

@Composable
fun HistoryList(list: List<HistoryItem>){
    LazyColumn {
        items(list) { item ->
            HistoryItemCard(historyItem = item)
        }
    }
}