package com.example.coffe_log.screens



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.coffe_log.ui.theme.CoffeViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.coffe_log.R
import com.example.coffe_log.ui.theme.QuoteUiState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment


@Composable
fun MotivationMessagesScreen(
    vm: CoffeViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

    //        Text(text = vm.quotesUiState)
            when (vm.quotesUiState) {
                is QuoteUiState.Loading -> LoadingScreen(modifier = modifier)
                is QuoteUiState.Success -> ResultScreen(
                   (vm.quotesUiState as QuoteUiState.Success).quotes, modifier = modifier
                )
                is QuoteUiState.Error -> ErrorScreen( modifier = modifier)
            }

    }
}

@Composable
fun ResultScreen(
    quotes: String,
    modifier: Modifier = Modifier
) {
    Text(text = quotes)
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier) {
        Text(text = "Loading")
        Image(
            modifier = modifier.size(200.dp),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = "Loading"
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_connection_error),
                contentDescription = ""
            )
            Text(text = "Connection error", modifier = Modifier.padding(16.dp))
        }
    }
}


