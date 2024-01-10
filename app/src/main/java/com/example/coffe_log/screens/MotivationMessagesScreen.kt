package com.example.coffe_log.screens



import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.coffe_log.ui.theme.CoffeViewModel
import androidx.compose.ui.Modifier



@Composable
fun MotivationMessagesScreen(
    vm: CoffeViewModel,
    modifier: Modifier = Modifier
) {
    Column {
        Text(text = vm.quotesUiState)
    }
}