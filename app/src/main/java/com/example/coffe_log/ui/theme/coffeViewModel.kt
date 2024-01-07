package com.example.coffe_log.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


data class CoffeUiState(
    var count: Int = 0,
    var coffeLogs: MutableList<Int> = mutableListOf()
)

class CoffeViewModel : ViewModel() {
        // Expose screen UI state
    private val _uiState = MutableStateFlow(CoffeUiState())
    val uiState: StateFlow<CoffeUiState> = _uiState.asStateFlow()

    fun onLog() {
        _uiState.value = _uiState.value.copy(
            count = _uiState.value.count + 1
        )
        _uiState.value.coffeLogs.add(_uiState.value.count)
    }
    fun countNumber(): Int {
        return _uiState.value.coffeLogs.size
    }

    fun getLogs(): List<Int> {
        return _uiState.value.coffeLogs
    }

}