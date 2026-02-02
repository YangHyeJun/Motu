package com.example.motu.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.motu.ui.main.MainView
import com.example.motu.ui.main.home.ui_items.domestic.DomesticDetailView
import com.example.motu.ui.splash.SplashView

@Composable
fun NavigateManager() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashView(
                onSplashFinished = {
                    navController.navigate("main") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }
        composable("main") {
            MainView(navController)
        }

        composable("domestic_stock_detail") {
            DomesticDetailView()
        }
    }
}
