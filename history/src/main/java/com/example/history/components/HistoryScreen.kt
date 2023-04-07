package com.example.history.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.database.model.HistoryItem

@Composable
fun HistoryScreen(
    modifier: Modifier,
    list: List<HistoryItem>,
) {
    if (list.isEmpty()) {
        HistoryEmptyScreen ()
    } else {
        HistoryList(list = list)
    }
}