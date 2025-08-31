package com.example.motu.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.motu.R
import com.example.motu.common.ui.BaseImageButton
import com.example.motu.common.ui.CommonStickyTabBar
import com.example.motu.common.ui.MotuTextStyle
import com.example.motu.ui.main.home.HomeView
import com.example.motu.ui.main.rising_stock.RapidlyRisingStocks

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    val viewModel: MainViewModel = hiltViewModel()

    // 리스트 스크롤 상태는 UI 책임 (뷰모델로 올리지 않음)
    val listState = rememberLazyListState()

    // 최상단 여부
    val atTop by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex == 0 && listState.firstVisibleItemScrollOffset == 0
        }
    }

    // 임계값(px) 계산
    val toggleThresholdPx = with(LocalDensity.current) { 2.dp.toPx() }

    // VM의 가시성 상태 구독
    val tabBarVisible by viewModel.tabBarVisible.collectAsState()

    // 스크롤 방향 감지 → viewModel에 위
    val nestedConnection = remember(viewModel, atTop, toggleThresholdPx) {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                viewModel.onScrollDelta(
                    dy = available.y,
                    atTop = atTop,
                    thresholdPx = toggleThresholdPx
                )
                return Offset.Zero
            }
        }
    }

    // 최상단이면 항상 보이도록 보정
    LaunchedEffect(atTop) { viewModel.forceShowIfAtTop(atTop) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // 탭바: 투명 오버레이 + 스크롤 방향에 따라 토글, 최상단이면 항상 보임
                    AnimatedVisibility(
                        visible = tabBarVisible || atTop,
                        enter = slideInVertically { -it } + fadeIn(),
                        exit  = slideOutVertically { -it } + fadeOut(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .zIndex(1f)
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
            // 각 탭은 기존대로. HomeView는 state만 받게 구성 권장
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
