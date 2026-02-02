package com.example.motu.ui.main.home.ui_items.domestic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.motu.conf.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DomesticStocksViewModel @Inject constructor() : ViewModel() {

    private val _navigationEvent =
        MutableSharedFlow<DomesticNavigationEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    fun goDetail() {
        viewModelScope.launch {
            _navigationEvent.emit(DomesticNavigationEvent.GoDomesticStockDetail)
        }
    }
}

