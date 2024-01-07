package com.example.coffe_log.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coffe_log.components.BarBottom


@Composable
fun LogEventsScreen(
    onAClicked: () -> Unit,
    onBClicked: () -> Unit,
    onCClicked: () -> Unit,
    onDClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Scaffold(
        bottomBar = {
            BarBottom(
                onAClicked = onAClicked,
                onBClicked = onBClicked,
                onCClicked = onCClicked,
                onDClicked = onDClicked
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column {
                Text(text = "LogEventsScreen")
                Button(
                    onClick = onAClicked
                ) {
                    Text(text = "Log Events")
                }
            }
        }
    }
}