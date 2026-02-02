package com.example.motu.ui.main.home.ui_items.domestic

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.motu.conf.HandleNavigationEvent

@Composable
fun DomesticStocksRoute(
    navController: NavHostController,
    viewModel: DomesticStocksViewModel = hiltViewModel()
) {
    HandleNavigationEvent(
        events = viewModel.navigationEvent,
        navController = navController
    ) { event ->
        when (event) {
            DomesticNavigationEvent.GoDomesticStockDetail -> {
                navController.navigate("domestic_stock_detail")
            }
        }
    }

    DomesticHoldingStocksView()
}
