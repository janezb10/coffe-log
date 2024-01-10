package com.example.coffe_log.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffe_log.ui.theme.CoffeViewModel


@Composable
fun SettingsScreen(
    vm: CoffeViewModel,
    onClickLogout: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {vm.deleteData()},
                modifier = Modifier
                    .padding(bottom = 20.dp)
            ) {
                Text(
                    text = "Delete Data",
                    fontSize = 30.sp
                )
            }
            Button(
                onClick = onClickLogout,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            ) {
                Text(
                    text = "Logout",
                    fontSize = 30.sp
                )
            }
        }
    }

}