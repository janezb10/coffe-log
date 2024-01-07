import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffe_log.components.BarBottom
import com.example.coffe_log.screens.DisplayDataScreen
import com.example.coffe_log.screens.LogEventsScreen
import com.example.coffe_log.screens.MotivationMessagesScreen
import com.example.coffe_log.screens.SettingsScreen
import com.example.coffe_log.screens.SettingsScreen
import com.example.coffe_log.screens.StartScreen
import com.example.coffe_log.ui.theme.CoffeViewModel

enum class CoffeLogScreen {
    Start,
    LogEvents,
    DisplayData,
    MotivationMessages,
    Settings,
}

@Composable
fun CoffeLogApp(
    modifier: Modifier = Modifier
) {
    var count = rememberSaveable{ mutableStateOf(0) }
    val viewModel: CoffeViewModel = viewModel()

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CoffeLogScreen.Start.name
    ) {
        composable(CoffeLogScreen.Start.name) {
            StartScreen(
                onLoginClicked = {
                    navController.navigate(CoffeLogScreen.LogEvents.name)
                }
            )
        }
        composable(CoffeLogScreen.LogEvents.name) {
            Screenn(
                onAClicked = {
                    navController.navigate(CoffeLogScreen.LogEvents.name)
                },
                onBClicked = {
                    navController.navigate(CoffeLogScreen.DisplayData.name)
                },
                onCClicked = {
                    navController.navigate(CoffeLogScreen.MotivationMessages.name)
                },
                onDClicked = {
                    navController.navigate(CoffeLogScreen.Settings.name)
                },
                content = {
                    LogEventsScreen(
                        onLog = {
                            count.value = count.value + 1
                            viewModel.onLog()
                        },
                        count = count.value,
                        ccount = viewModel.countNumber()
//                        ccount = viewModel.uiState.value.count
                    )
                }
            )
        }
        composable(CoffeLogScreen.DisplayData.name) {
            Screenn(
                onAClicked = {
                    navController.navigate(CoffeLogScreen.LogEvents.name)
                },
                onBClicked = {
                    navController.navigate(CoffeLogScreen.DisplayData.name)
                },
                onCClicked = {
                    navController.navigate(CoffeLogScreen.MotivationMessages.name)
                },
                onDClicked = {
                    navController.navigate(CoffeLogScreen.Settings.name)
                },
                content = {
                    DisplayDataScreen()
                }
            )
        }
        composable(CoffeLogScreen.MotivationMessages.name) {
            Screenn(
                onAClicked = {
                    navController.navigate(CoffeLogScreen.LogEvents.name)
                },
                onBClicked = {
                    navController.navigate(CoffeLogScreen.DisplayData.name)
                },
                onCClicked = {
                    navController.navigate(CoffeLogScreen.MotivationMessages.name)
                },
                onDClicked = {
                    navController.navigate(CoffeLogScreen.Settings.name)
                },
                content = {
                    MotivationMessagesScreen()
                }
            )
        }
        composable(CoffeLogScreen.Settings.name) {
            Screenn(
                onAClicked = {
                    navController.navigate(CoffeLogScreen.LogEvents.name)
                },
                onBClicked = {
                    navController.navigate(CoffeLogScreen.DisplayData.name)
                },
                onCClicked = {
                    navController.navigate(CoffeLogScreen.MotivationMessages.name)
                },
                onDClicked = {
                    navController.navigate(CoffeLogScreen.Settings.name)
                },
                content = {
                    SettingsScreen()
                }
            )
        }
    }
}

@Composable
fun Screenn(
    onAClicked: () -> Unit,
    onBClicked: () -> Unit,
    onCClicked: () -> Unit,
    onDClicked: () -> Unit,
    content: @Composable () -> Unit,
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
            content()
        }
    }
}