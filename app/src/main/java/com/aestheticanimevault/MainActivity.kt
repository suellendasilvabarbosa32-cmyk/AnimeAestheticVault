
package com.aestheticanimevault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aestheticanimevault.ui.HomeScreen
import com.aestheticanimevault.ui.WallpaperDetailScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = androidx.compose.material3.darkColorScheme(
                    background = androidx.compose.ui.graphics.Color(0xFF121212),
                    surface = androidx.compose.ui.graphics.Color(0xFF1E1E1E),
                    primary = androidx.compose.ui.graphics.Color(0xFFBB86FC)
                )
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                onWallpaperClick = { wallpaperId ->
                    navController.navigate("detail/$wallpaperId")
                }
            )
        }

        composable(
            route = "detail/{wallpaperId}",
            arguments = listOf(
                navArgument("wallpaperId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val wallpaperId =
                backStackEntry.arguments?.getInt("wallpaperId") ?: 0

            WallpaperDetailScreen(
                wallpaperId = wallpaperId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
