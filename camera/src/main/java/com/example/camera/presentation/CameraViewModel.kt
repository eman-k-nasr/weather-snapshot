package com.example.camera.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.model.HistoryItem
import com.example.database.repo.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
    private val historyRepository: HistoryRepository
): ViewModel() {

    fun insertHistoryItem(item: HistoryItem){
        viewModelScope.launch {
            historyRepository.insert(item)
        }
    }
}