package com.example.coffe_log.screens


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffe_log.ui.theme.CoffeViewModel


@Composable
fun DisplayDataScreen(
    vm: CoffeViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
        .fillMaxWidth()
        .padding(17.dp)
    ) {
        Text(text = "Last: ${vm.timeSinceLastUsage()}")
        if (vm.wasThereAUsage()) {
            Text(text = "Today: ${vm.todayUsage()}")
            Text(text = "Yesterday: ${vm.yesterdayUsage()}")
            Text(text = "This week: ${vm.weekUsage()}")
            Text(text = "This month: ${vm.monthUsage()}")
            Text(text = "Total: ${vm.totalUsage()}")
        }
    }
    LazyColumn {
//        items = Higher order function
        items (vm.getLogs().size) {
            val time = vm.getLogs()[it].first
            val message = vm.getLogs()[it].second
            Column(
                modifier = Modifier
                    .border(1.dp, color = com.example.coffe_log.ui.theme.dark_Custom1Container)
                    .fillMaxWidth()
                    .padding(7.dp)
            ) {
                Text(
                    text = "${time.year}-${time.monthValue}-${time.dayOfMonth} ${time.hour}:${time.minute}:${time.second}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                )
                if (message != "") {
                    Text(
                        text = message,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp)
                        )
                }
            }
        }
    }
}


@Preview
@Composable
fun DisplayDataScreenPreview() {
    DisplayDataScreen(vm = CoffeViewModel())
}
