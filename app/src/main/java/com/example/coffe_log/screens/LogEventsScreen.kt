package com.example.coffe_log.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.coffe_log.components.BarBottom
import com.example.coffe_log.ui.theme.CoffeViewModel


@Composable
fun LogEventsScreen(
    onLog: () -> Unit,
    vm: CoffeViewModel,
    countt: Int,
    modifier: Modifier = Modifier
) {
    val adittionalMessage = remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

//            ADITIONAL MESSAGES
            TextField(
                value = adittionalMessage.value,
                onValueChange = { newText -> adittionalMessage.value = newText },
                label = { Text("Aditional Message") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Button(
                onClick = {
                    vm.onLog(adittionalMessage.value)
                    adittionalMessage.value = ""
//                  onLog() for refresing the screen lol
                    onLog()
                },
                modifier = Modifier
                    .size(170.dp)
                    .clip(CircleShape)
            ) {
                Icon(
                    Icons.Filled.CheckCircle,
                    contentDescription = "Cicon",
                    Modifier.size(160.dp)
                )
            }
            Text(
                text = "Today: ${vm.todayUsage()}",
                modifier = Modifier.padding( top = 30.dp)
            )
            Text(
                text = "Yesterday: ${vm.yesterdayUsage()}",
                modifier = Modifier.padding( top = 10.dp)
            )
            Text(
                text = "Last: ${vm.timeSinceLastUsage()} ",
                modifier = Modifier.padding( top = 10.dp)
            )
        }
    }
}