package LucasVendramini.com.github.checkpoint_navigationbetweenscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import LucasVendramini.com.github.checkpoint_navigationbetweenscreen.screens.LoginScreen
import LucasVendramini.com.github.checkpoint_navigationbetweenscreen.screens.MenuScreen
import LucasVendramini.com.github.checkpoint_navigationbetweenscreen.screens.PedidosScreen
import LucasVendramini.com.github.checkpoint_navigationbetweenscreen.screens.PerfilScreen
import LucasVendramini.com.github.checkpoint_navigationbetweenscreen.ui.theme.CheckpointNavigationBetweenScreenTheme
import androidx.compose.foundation.layout.padding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckpointNavigationBetweenScreenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "pedidos") {
                            PedidosScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "perfil") {
                            PerfilScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                    }
                }
            }
        }
    }
}
