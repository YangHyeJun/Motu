package com.example.motu.conf

import androidx.navigation.NavHostController
import javax.inject.Inject
import javax.inject.Singleton

interface AppNavigator {
    fun navigate(route: String)
}

@Singleton
class AppNavigatorImpl @Inject constructor() : AppNavigator {
    lateinit var navController: NavHostController

    override fun navigate(route: String) {
        navController.navigate(route)
    }
}
