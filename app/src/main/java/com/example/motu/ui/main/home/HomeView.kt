package com.example.motu.ui.main.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.motu.common.ui.ListBox
import com.example.motu.common.ui.StockRow


@Composable
fun HomeView(listState: LazyListState) {
    val viewModel: HomeViewModel = hiltViewModel()

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp)
    ) {
        item { DomesticHoldingStocks() }
        item { ForeignHoldingStocks() }
        item { ShortSellingRanking() }
    }
}

@Composable
fun DomesticHoldingStocks() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ListBox(
            title = "국내 보유주식",
            showMoreButton = true,
            resultTitle = "총 4종목",
            resultContent = "49,124,000원"
        ) {
            StockRow("삼성전자", "005930", "10주", "74,500원", "▲ +3.4%", amount = "9,384,000원")
            HorizontalDivider(color = Color(0xFFF1F5F9))
            StockRow("SK하이닉스", "000660", "5주", "128,500원", "▲ +0.4%", amount = "324,000원")
            HorizontalDivider(color = Color(0xFFF1F5F9))
            StockRow("LG에너지솔루션", "373220", "1233주", "385,000원", "▲ +13.4%", amount = "19,384,000원")
            HorizontalDivider(color = Color(0xFFF1F5F9))
            StockRow("삼성전자", "005930", "10주", "74,500원", "▲ +3.4%", amount = "9,384,000원")
            HorizontalDivider(color = Color(0xFFF1F5F9))
            StockRow("SK하이닉스", "000660", "5주", "128,500원", "▲ +0.4%", amount = "324,000원")
            HorizontalDivider(color = Color(0xFFF1F5F9))
            StockRow("LG에너지솔루션", "373220", "1233주", "385,000원", "▲ +13.4%", amount = "19,384,000원")
        }
    }
}

@Composable
fun ForeignHoldingStocks() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ListBox(
            title = "해외 보유주식",
            showMoreButton = true,
            resultTitle = "총 4종목",
            resultContent = "49,124,000원"
        ) {
            StockRow("삼성전자", "005930", "10주", "74,500원", "▲ +3.4%", amount = "9,384,000원")
            HorizontalDivider(color = Color(0xFFF1F5F9))
            StockRow("SK하이닉스", "000660", "5주", "128,500원", "▲ +0.4%", amount = "324,000원")
            HorizontalDivider(color = Color(0xFFF1F5F9))
            StockRow("LG에너지솔루션", "373220", "1233주", "385,000원", "▲ +13.4%", amount = "19,384,000원")
        }
    }
}

@Composable
fun ShortSellingRanking() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ListBox(
            title = "공매도 순위",
            showMoreButton = true,
            resultTitle = "총 4종목",
            resultContent = "49,124,000원"
        ) {
            StockRow("삼성전자", "005930", "10주", "74,500원", "▲ +3.4%", amount = "9,384,000원")
            HorizontalDivider(color = Color(0xFFF1F5F9))
            StockRow("SK하이닉스", "000660", "5주", "128,500원", "▲ +0.4%", amount = "324,000원")
            HorizontalDivider(color = Color(0xFFF1F5F9))
            StockRow("LG에너지솔루션", "373220", "1233주", "385,000원", "▲ +13.4%", amount = "19,384,000원")
        }
    }
}