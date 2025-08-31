package com.example.motu.ui.main.rising_stock

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RapidlyRisingStocks() {
    val viewModel: RisingStocksViewModel = hiltViewModel()

    Text("급등 종목 화면", modifier = Modifier.padding(16.dp))

}