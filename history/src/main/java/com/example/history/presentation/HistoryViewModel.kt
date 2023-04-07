package com.example.history.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.model.HistoryItem
import com.example.database.repo.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val historyRepository: HistoryRepository
): ViewModel() {

    private val _history: MutableStateFlow<List<HistoryItem>> = MutableStateFlow(arrayListOf())
    val history = _history.asStateFlow()

    init {
        viewModelScope.launch {
            _history.emit(getAllHistory())
        }
    }

    private suspend fun getAllHistory(): List<HistoryItem>{
        return withContext(viewModelScope.coroutineContext) {
            historyRepository.getAllHistory()
        }
    }

    private fun getHistoryById(id: Int){
        viewModelScope.launch {
            historyRepository.getHistoryById(id)
        }
    }

    private fun insertHistoryItem(item: HistoryItem){
        viewModelScope.launch {
            historyRepository.insert(item)

        }
    }

    private fun deleteAllHistory(){
        viewModelScope.launch {
            historyRepository.deleteAllHistory()
        }
    }

    private fun deleteHistoryItem(item: HistoryItem){
        viewModelScope.launch{
            historyRepository.delete(item)
        }
    }

}