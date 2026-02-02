package com.example.motu.conf

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.Flow

/**
 * App-level marker interface for navigation events
 */
interface AppNavigationEvent

@Composable
fun <T : AppNavigationEvent> HandleNavigationEvent(
    events: Flow<T>,
    navController: NavHostController,
    onEvent: (T) -> Unit
) {
    LaunchedEffect(events) {
        events.collect { event ->
            onEvent(event)
        }
    }
}
