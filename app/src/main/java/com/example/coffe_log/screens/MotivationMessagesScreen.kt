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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.coffe_log.network.Quote


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
    quotes: List<Quote>,
    modifier: Modifier = Modifier
) {
    var index by rememberSaveable { mutableStateOf(0) }
    val authorName = quotes[index].author.split(",")[0]
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        ) {
        Text(
            text = quotes[index].tekst,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(bottom = 20.dp, start = 15.dp, end = 15.dp)
        )
    }
    Row {
        Text(
            text = authorName,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            modifier = modifier
                .fillMaxWidth()
                .padding(end = 55.dp)
        )

    }
    Button(
        onClick = { index = (index + 1) % quotes.size },
        modifier = modifier
            .padding(top = 50.dp)
    ) {
        Text(text = "Next Quote")
    }
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


