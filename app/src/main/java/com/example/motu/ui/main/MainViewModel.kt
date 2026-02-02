package com.example.motu.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.abs

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    // 탭 상태
    var selectedTabIndex by mutableIntStateOf(0)
        private set

    var noticeMessage by mutableStateOf("수익률보다 중요한 건 꾸준한 투자 습관입니다.")
        private set

    fun onTabSelected(index: Int) {
        selectedTabIndex = if (selectedTabIndex == index + 1) 0 else index + 1
    }

    // ── 탭바 가시성 로직 ────────────────────────────────────────────────────────
    private val _tabBarVisible = MutableStateFlow(true)
    val tabBarVisible: StateFlow<Boolean> = _tabBarVisible

    // 미세 스크롤 무시를 위한 버퍼
    private var scrollBufferPx = 0f

    /**
     * 스크롤 델타를 전달받아 탭바 가시성을 갱신.
     * @param dy available.y (음수=아래로 스크롤/콘텐츠 위로, 양수=위로 스크롤/콘텐츠 아래로)
     * @param atTop 리스트 최상단 여부 (true면 항상 보이도록 강제)
     * @param thresholdPx 토글 임계값(px)
     */
    fun onScroll(
        dy: Float,
        atTop: Boolean
    ) {
        when {
            atTop -> {
                // 최상단이면 무조건 보이기
                _tabBarVisible.value = true
            }
            dy > 0 -> {
                // 위로 끌어올리는 중 (scroll up)
                _tabBarVisible.value = true
            }
        }
    }


    /** 외부에서 최상단 진입을 감지했을 때 강제로 보이도록 */
    fun forceShowIfAtTop(atTop: Boolean) {
        if (atTop && !_tabBarVisible.value) _tabBarVisible.value = true
    }
}
