package com.example.coffe_log.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.coffe_log.R
import com.example.coffe_log.ui.theme.CoffeViewModel


@Composable
fun LogEventsScreen(
    onLog: () -> Unit,
    vm: CoffeViewModel,
    countt: Int,
    modifier: Modifier = Modifier
) {
    val adittionalMessage = remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            OutlinedTextField(
                value = adittionalMessage.value,
                onValueChange = { newText -> adittionalMessage.value = newText },
                label = { Text("Aditional Message") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .padding(bottom = 15.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
            )
            Button(
                onClick = {
                    focusManager.clearFocus()


                    vm.onLog(adittionalMessage.value)
                    adittionalMessage.value = ""
//                  onLog() for refresing the screen lol
                    onLog()
                },
                modifier = Modifier
                    .size(170.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(160.dp)
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