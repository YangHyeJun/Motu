package com.example.motu.ui.main.home

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.motu.ui.main.home.ui_items.domestic.DomesticStocksRoute

@Composable
fun HomeRoute(
    navController: NavHostController,
    listState: LazyListState
) {
    HomeView(
        listState = listState,
        domesticSection = {
            DomesticStocksRoute(navController)
        }
    )
}
