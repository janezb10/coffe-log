package com.example.coffe_log.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime


data class CoffeUiState(
//    var count: Int = 0,
    var coffeLogs: MutableList<LocalDateTime> = mutableListOf(),
    var coffeLogsAndMessagePair: MutableList<Pair<LocalDateTime, String>> = mutableListOf(),
)

class CoffeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CoffeUiState())
    val uiState: StateFlow<CoffeUiState> = _uiState.asStateFlow()

    fun onLog(aditionalMessage: String = "") {
//        _uiState.value = _uiState.value.copy(
//            count = _uiState.value.count + 1
//        )
        _uiState.value.coffeLogs.add(LocalDateTime.now())

        _uiState.value.coffeLogsAndMessagePair.add(Pair(LocalDateTime.now(), aditionalMessage))
    }

    fun countNumber(): Int {
        return _uiState.value.coffeLogs.size
    }

    fun getLogs(): MutableList<Pair<LocalDateTime, String>> {
//        var a = _uiState.value.coffeLogs
//        var b = mutableListOf<String>()
//        for (i in a) {
//            b.add(i.toString())
//        }
//        return b

//        var a = _uiState.value.coffeLogsAndMessagePair
//        var b = mutableListOf<Pair<String, String>>()
//        for (i in a) {
//            b.add(Pair(i.first.toString(), i.second))
//        }
//        return b
        return _uiState.value.coffeLogsAndMessagePair
    }

    fun todayUsage(): Int {
        var a = _uiState.value.coffeLogs
        var b = 0
        for (i in a) {
            if (i.dayOfYear == LocalDateTime.now().dayOfYear) {
                b += 1
            }
        }
        return b
    }

    fun yesterdayUsage(): Int {
        var a = _uiState.value.coffeLogs
        var b = 0
        for (i in a) {
            if (i.dayOfYear == LocalDateTime.now().dayOfYear - 1) {
                b += 1
            }
        }
        return b
    }

    fun weekUsage(): Int {
        var a = _uiState.value.coffeLogs
        var b = 0
        for (i in a) {
            if (i.dayOfYear >= LocalDateTime.now().dayOfYear - 7) {
                b += 1
            }
        }
        return b
    }

    fun monthUsage(): Int {
        var a = _uiState.value.coffeLogs
        var b = 0
        for (i in a) {
            if (i.dayOfYear >= LocalDateTime.now().dayOfYear - 30) {
                b += 1
            }
        }
        return b
    }

    fun totalUsage(): Int {
        return _uiState.value.coffeLogs.size
    }

    fun lastTenUsages(): List<LocalDateTime> {
        return _uiState.value.coffeLogs.takeLast(10)
    }


//BUG: minute se po uri odštevjo al po pou uri nwm
    fun timeSinceLastUsage(): String {
        var a = _uiState.value.coffeLogs
        if (a.isEmpty()) {
            return "No usage yet"
        }
        var b:LocalDateTime = a[a.size - 1]
        var c = LocalDateTime.now()
        c = c.minusHours(b.hour.toLong())
        c = c.minusMinutes(b.minute.toLong())
//        c = c.minusSeconds(b.second.toLong())
        var d = c.hour
        var e = c.minute
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

}