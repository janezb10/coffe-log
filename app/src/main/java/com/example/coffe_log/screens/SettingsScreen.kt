package com.example.coffe_log.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coffe_log.ui.theme.CoffeViewModel


@Composable
fun SettingsScreen(
    vm: CoffeViewModel,
    onClickLogout: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Text(text = "SettingsScreen")
        Button(
            onClick = {vm.deleteData()}
        ) {
            Text(text = "Delete Data")
        }
        Button(
            onClick = onClickLogout
        ) {
            Text(
                text = "Logout"
            )
        }
    }
}