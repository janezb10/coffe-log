package com.example.coffe_log.screens


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coffe_log.ui.theme.CoffeViewModel


@Composable
fun DisplayDataScreen(
    vm: CoffeViewModel,
    modifier: Modifier = Modifier
) {
    Column {
        Text(text = "Last: ${vm.timeSinceLastUsage()}")
        Text(text = "Today: ${vm.todayUsage()}")
        Text(text = "Yesterday: ${vm.yesterdayUsage()}")
        Text(text = "This week: ${vm.weekUsage()}")
        Text(text = "This month: ${vm.monthUsage()}")
        Text(text = "Total: ${vm.totalUsage()}")
    }
    LazyColumn {
//        items = Higher order function
        items (vm.getLogs().size) {
            val time = vm.getLogs()[it].first
            val message = vm.getLogs()[it].second
            Box(
                modifier = Modifier
                    .border(1.dp, color = androidx.compose.ui.graphics.Color.Black)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(text = "${time.year}-${time.monthValue}-${time.dayOfMonth} ${time.hour}:${time.minute}:${time.second}")
                    Text(text = message)
                }

            }
        }
    }
}
