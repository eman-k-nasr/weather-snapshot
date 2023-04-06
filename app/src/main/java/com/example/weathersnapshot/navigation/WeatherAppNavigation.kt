package com.example.weathersnapshot.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actions.Actions
import com.example.weathersnapshot.components.HistoryScreen
import com.example.weathersnapshot.components.HomeScreen
import com.example.weathersnapshot.components.StartScreen
import com.example.weathersnapshot.navigation.Routes.HISTORY_SCREEN
import com.example.weathersnapshot.navigation.Routes.HOME_SCREEN
import com.example.weathersnapshot.navigation.Routes.START_SCREEN

@Composable
fun WeatherAppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HOME_SCREEN
) {
    val context = LocalContext.current

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(HOME_SCREEN) {
            HomeScreen(
                takeSnapshot = {
                   navController.navigate(START_SCREEN)
                },
                viewHistory = {
                    navController.navigate(HISTORY_SCREEN)
                }
            )
        }
        composable(START_SCREEN) {
            StartScreen(
                modifier = modifier,
                openWeatherScreen = {
                   context.startActivity(
                     Actions.openWeatherActivity(context = context)
                   )
                }
            )
        }
        composable(HISTORY_SCREEN){
            HistoryScreen(
                onGetStartClicked = { navController.navigate(START_SCREEN) }
            )
        }
    }
}