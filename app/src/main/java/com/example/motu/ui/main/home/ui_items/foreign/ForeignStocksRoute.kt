package com.example.motu.ui.main.home.ui_items.foreign

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.motu.conf.HandleNavigationEvent

@Composable
fun ForeignStocksRoute(
    navController: NavHostController,
    viewModel: ForeignStocksViewModel = hiltViewModel()
) {
    HandleNavigationEvent(
        events = viewModel.navigationEvent,
        navController = navController
    ) { event ->
        when (event) {
            ForeignNavigationEvent.GoForeignStocksDetail -> {
                navController.navigate("domestic_stock_detail")
            }
        }
    }
    ForeignHoldingStocksView()
}
