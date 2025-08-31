package com.example.motu.common.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun StockRow(
    name: String,
    code: String,
    quantity: String,
    price: String,
    changeText: String,
    changeColor: Color = Color(0xFFE7000B),
    amount: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                    color = Color(0xFF0F172A)
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = "($code)",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color(0xFF94A3B8)
                )
            }
            Spacer(Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = quantity,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color(0xFF475569)
                )
                Text(
                    text = " · $price",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color(0xFF94A3B8)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = changeText,
                    style = MaterialTheme.typography.labelLarge,
                    color = changeColor
                )
            }
        }
        Text(
            text = amount,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
            color = Color(0xFF0F172A),
            textAlign = TextAlign.End,
            modifier = Modifier.widthIn(min = 110.dp)
        )
    }
}