package com.example.motu.ui.main.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.motu.ui.main.home.ui_items.AssetInfo
import com.example.motu.ui.main.home.ui_items.ForeignHoldingStocks
import com.example.motu.ui.main.home.ui_items.ShortSellingRanking
import com.example.motu.ui.main.home.ui_items.domestic.DomesticHoldingStocksView
import com.example.motu.ui.main.home.ui_items.domestic.DomesticStocksRoute


@Composable
fun HomeView(
    listState: LazyListState,
    domesticSection: @Composable () -> Unit
) {
    val viewModel: HomeViewModel = hiltViewModel()

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp)
    ) {
        item { AssetInfo() }
        item { domesticSection() }
        item { ForeignHoldingStocks() }
        item { ShortSellingRanking() }
    }
}
