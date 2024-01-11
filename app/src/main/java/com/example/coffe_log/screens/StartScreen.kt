package com.example.coffe_log.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffe_log.R


@Composable
fun StartScreen(
    onLoginClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val usernameInput = remember { mutableStateOf("") }
    val passwordInput = remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(250.dp)
                    .padding(bottom = 50.dp)
            )
            TextField(
                value = usernameInput.value,
                onValueChange = { newText -> usernameInput.value = newText },
                label = { Text("Username") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextField(
                value = passwordInput.value,
                onValueChange = { newText -> passwordInput.value = newText },
                label = { Text("Password") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardActions = KeyboardActions(
                    onDone = {
                        login(onLoginClicked, usernameInput.value, passwordInput.value)
                    }
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Button(
                onClick = {
                    login(onLoginClicked, usernameInput.value, passwordInput.value)
                },
                modifier = Modifier.padding(top = 15.dp)
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                    )
                )
            }
        }
    }
}

private fun login(
    onLoginDemanded: () -> Unit,
    usernameI: String,
    passwordI: String
) {
    val username = "user"
    val password = "pass"
    if (usernameI == username && passwordI == password) {
        onLoginDemanded()
    }
    onLoginDemanded()
}

@Preview
@Composable
fun StartScreenPreview() {
    StartScreen(onLoginClicked = {})
}