package com.example.motu.common.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BaseImageButton(
    resId: Int,
    contentDescription: String? = null,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Image(
            painter = painterResource(id = resId),
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp)
        )
    }
}