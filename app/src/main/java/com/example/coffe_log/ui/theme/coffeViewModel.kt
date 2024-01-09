package com.example.coffe_log.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime


data class CoffeUiState(
    var coffeLogs: MutableList<LocalDateTime> = mutableListOf(),
    var coffeLogsAndMessagePair: MutableList<Pair<LocalDateTime, String>> = mutableListOf(),
)

class CoffeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CoffeUiState())
    val uiState: StateFlow<CoffeUiState> = _uiState.asStateFlow()

    fun onLog(aditionalMessage: String = "") {
        _uiState.value.coffeLogs.add(LocalDateTime.now())
        _uiState.value.coffeLogsAndMessagePair.add(Pair(LocalDateTime.now(), aditionalMessage))
    }


    fun getLogs(): MutableList<Pair<LocalDateTime, String>> {
        return _uiState.value.coffeLogsAndMessagePair
    }

    fun todayUsage(): Int {
        val a = _uiState.value.coffeLogs
        return a.filter { it.dayOfYear == LocalDateTime.now().dayOfYear }.size
    }

    fun yesterdayUsage(): Int {
        val a = _uiState.value.coffeLogs
        return a.filter { it.dayOfYear == LocalDateTime.now().dayOfYear - 1 }.size
    }

    fun weekUsage(): Int {
        val a = _uiState.value.coffeLogs
        return a.filter { it.dayOfYear >= LocalDateTime.now().dayOfYear - 7 }.size
    }


    fun monthUsage(): Int {
        val a = _uiState.value.coffeLogs
        val b = a.filter { it.dayOfYear >= LocalDateTime.now().dayOfYear - 30 }.size
        return b
    }

    fun totalUsage(): Int {
        return _uiState.value.coffeLogs.size
    }

    fun lastTenUsages(): List<LocalDateTime> {
        return _uiState.value.coffeLogs.takeLast(10)
    }


    fun timeSinceLastUsage(): String {
        val a = _uiState.value.coffeLogs
        if (a.isEmpty()) {
            return "No usage yet"
        }
        val b:LocalDateTime = a[a.size - 1]
        var c = LocalDateTime.now()
        c = c.minusHours(b.hour.toLong())
        c = c.minusMinutes(b.minute.toLong())
//        c = c.minusSeconds(b.second.toLong())
        val d = c.hour
        val e = c.minute
//        var h = c.second
        var f = "hours"
        if (d == 1) {
            f = "hour"
        }
        var g = "minutes"
        if (e == 1) {
            g = "minute"
        }
        return "$d $f and $e $g ago"
    }

    fun deleteData(): Unit {
        _uiState.value = CoffeUiState()
    }

}