import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffe_log.screens.DisplayDataScreen
import com.example.coffe_log.screens.LogEventsScreen
import com.example.coffe_log.screens.MotivationMessagesScreen
import com.example.coffe_log.screens.SettingsScreen
import com.example.coffe_log.screens.SettingsScreen
import com.example.coffe_log.screens.StartScreen

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
            LogEventsScreen(
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
                }
            )
        }
        composable(CoffeLogScreen.DisplayData.name) {
            DisplayDataScreen(
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
                onLogoutClicked = {
                    navController.navigate(CoffeLogScreen.Start.name)
                }
            )
        }
        composable(CoffeLogScreen.MotivationMessages.name) {
            MotivationMessagesScreen(
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
                onLogoutClicked = {
                    navController.navigate(CoffeLogScreen.Start.name)
                }
            )
        }
        composable(CoffeLogScreen.Settings.name) {
            SettingsScreen(
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
                onLogoutClicked = {
                    navController.navigate(CoffeLogScreen.Start.name)
                }
            )
        }
    }
}