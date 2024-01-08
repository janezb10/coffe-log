import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffe_log.components.BarBottom
import com.example.coffe_log.screens.DisplayDataScreen
import com.example.coffe_log.screens.LogEventsScreen
import com.example.coffe_log.screens.MotivationMessagesScreen
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
    val viewModel: CoffeViewModel = viewModel()

    val navController = rememberNavController()
    val countt = rememberSaveable { mutableIntStateOf(0) }

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
                        countt = countt.intValue,
                        onLog = {
                            countt.intValue = countt.intValue + 1
                        },
                        vm = viewModel,
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
                    DisplayDataScreen(
                        vm = viewModel
                    )
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
                    SettingsScreen(
                        vm = viewModel,
                        onClickLogout = {
                            navController.navigate(CoffeLogScreen.Start.name)
                        },
                        modifier = modifier
                    )
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