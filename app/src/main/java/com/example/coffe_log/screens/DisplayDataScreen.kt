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


//@Composable
//fun DisplayDataScreen(
//    onAClicked: () -> Unit,
//    onBClicked: () -> Unit,
//    onCClicked: () -> Unit,
//    onDClicked: () -> Unit,
//    onLogoutClicked: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//
//    Scaffold(
//        bottomBar = {
//            BarBottom(
//                onAClicked = onAClicked,
//                onBClicked = onBClicked,
//                onCClicked = onCClicked,
//                onDClicked = onDClicked
//            )
//        }
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(it)
//        ) {
//            Column {
//                Text(text = "DisplayDataScreen")
//                Button(
//                    onClick = onLogoutClicked
//                ) {
//                    Text(text = "Go to first screen")
//                }
//            }
//        }
//    }
//}

@Composable
fun DisplayDataScreen() {
    Column {
        Text(text = "DisplayDataScreen")

    }
}