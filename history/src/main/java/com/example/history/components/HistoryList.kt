package com.example.history.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.history.data.model.HistoryItem
import androidx.compose.foundation.lazy.items

@Composable
fun HistoryList(list: List<HistoryItem>){
    LazyColumn {
        items(list) { item ->
            HistoryItemCard(historyItem = item)
        }
    }
}