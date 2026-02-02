package com.example.motu.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.motu.R
import com.example.motu.common.ui.BaseImageButton
import com.example.motu.common.ui.CommonStickyTabBar
import com.example.motu.ui.main.home.HomeView
import com.example.motu.ui.main.rising_stock.RapidlyRisingStocks

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    val viewModel: MainViewModel = hiltViewModel()

    val listState = rememberLazyListState()

    // 최상단 여부
    val atTop by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex == 0 && listState.firstVisibleItemScrollOffset == 0
        }
    }

    // 가시성 상태 구독
    val tabBarVisible by viewModel.tabBarVisible.collectAsState()

    // 스크롤 방향 감
    val nestedConnection = remember(viewModel, atTop) {
        object : NestedScrollConnection {
            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                viewModel.onScroll(
                    dy = available.y,
                    atTop = atTop
                )
                return Offset.Zero
            }
        }
    }

    LaunchedEffect(atTop) { viewModel.forceShowIfAtTop(atTop) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    AnimatedVisibility(
                        visible = tabBarVisible,
                        enter = slideInVertically { -it } + fadeIn(),
                    ) {
                        CommonStickyTabBar(
                            selectedIndex = viewModel.selectedTabIndex,
                            onTabSelected = { viewModel.onTabSelected(it) }
                        )
                    }
                },
                actions = {
                    BaseImageButton(resId = R.drawable.appbar_notifications) { /* TODO */ }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .nestedScroll(nestedConnection)
        ) {
            TabContent(
                selectedIndex = viewModel.selectedTabIndex,
                listState = listState
            )
        }
    }
}

@Composable
fun TabContent(selectedIndex: Int, listState: LazyListState) {
    when (selectedIndex) {
        0 -> HomeView(listState)
        1 -> RapidlyRisingStocks()
        2 -> Text("거래대금 상위 화면", modifier = Modifier.padding(16.dp))
        3 -> Text("AI 추천 화면", modifier = Modifier.padding(16.dp))
        4 -> Text("외국인 순매수 화면", modifier = Modifier.padding(16.dp))
        5 -> Text("기관 순매수 화면", modifier = Modifier.padding(16.dp))
    }
}
