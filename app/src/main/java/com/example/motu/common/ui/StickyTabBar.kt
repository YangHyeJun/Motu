package com.example.motu.common.ui

import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.motu.R

data class StockTabItem(val image: Int, val label: String)

val stockTabItems = listOf(
    StockTabItem(R.drawable.appbar_chart, "급등 종목"),
    StockTabItem(R.drawable.appbar_dollar, "거래대금 상위"),
    StockTabItem(R.drawable.appbar_ai, "AI 추천"),
    StockTabItem(R.drawable.appbar_ai, "외국인 순매수"),      // TODO : Icon 추가
    StockTabItem(R.drawable.appbar_ai, "기관 순매수"),       // TODO : Icon 추가
)

@Composable
fun CommonStickyTabBar(
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        stockTabItems.forEachIndexed { index, item ->
            val isSelected = index == selectedIndex - 1

            val backgroundColor = if (isSelected) Color(0xFFF5F5F7) else Color.White
            val contentColor = if (isSelected) Color.Black else Color.Gray

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .shadow(
                        elevation = if (isSelected) 4.dp else 0.dp,
                        shape = RoundedCornerShape(24.dp)
                    )
                    .background(
                        color = backgroundColor,
                        shape = RoundedCornerShape(24.dp)
                    )
                    .clickable { onTabSelected(index) }
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = item.label,
                    modifier = Modifier.size(18.dp),
                    colorFilter = ColorFilter.tint(contentColor)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = item.label,
                    color = contentColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
