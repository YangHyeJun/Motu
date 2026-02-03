package com.example.motu.ui.main.home.ui_items.foreign

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForeignStocksViewModel @Inject constructor() : ViewModel() {
    private val _navigationEvent =
        MutableSharedFlow<ForeignNavigationEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    fun goDetail() {
        viewModelScope.launch {
            _navigationEvent.emit(ForeignNavigationEvent.GoForeignStocksDetail)
        }
    }
}