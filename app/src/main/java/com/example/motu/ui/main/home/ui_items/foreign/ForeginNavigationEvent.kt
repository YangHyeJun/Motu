package com.example.motu.ui.main.home.ui_items.foreign

import com.example.motu.conf.AppNavigationEvent

/**
 * DomesticStocks 화면에서 발생할 수 있는 Navigation 의도들
 *
 * - ViewModel → View 로 전달되는 1회성 이벤트
 * - 실제 NavController 호출은 View에서만 처리
 */

sealed interface ForeignNavigationEvent : AppNavigationEvent {
    data object GoForeignStocksDetail : ForeignNavigationEvent
}