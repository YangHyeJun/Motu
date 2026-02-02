package com.example.motu.common.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AssetInfo(
    // 데이터
    assetTotal: String = "12,340,000원",
    investedTotal: String = "10,000,000원",
    roiText: String = "▲ + 23.4%",
    profitAmountText: String = "+24,800,000원",
    bars: List<Float> = listOf(0.35f, 0.45f, 0.55f, 0.68f, 0.72f, 0.78f, 0.9f),

    // 스타일
    shape: Shape = RoundedCornerShape(18.dp),
    borderWidth: Dp = 1.dp,
    borderColors: List<Color> = listOf(Color(0xFFE9EBF2), Color(0xFFF6F8FA)),
    labelColor: Color = Color(0xFF8B93A6),
    valueColor: Color = Color(0xFF111827),
    accentRed: Color = Color(0xFFEF4444),
    modifier: Modifier = Modifier
) {
    // 바깥쪽: 그라데이션 테두리
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(borderWidth, Brush.linearGradient(borderColors), shape)
            .clip(shape) // 둥근 모서리 유지
    ) {
        // 안쪽: 카드 (그림자 + 흰 배경)
        Card(
            shape = shape,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                // LEFT
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("보유 자산", color = labelColor, style = MaterialTheme.typography.labelLarge)
                        Text(
                            assetTotal,
                            color = valueColor,
                            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("총 투자 금액", color = labelColor, style = MaterialTheme.typography.labelLarge)
                        Text(
                            investedTotal,
                            color = valueColor,
                            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("총 수익률", color = labelColor, style = MaterialTheme.typography.labelLarge)
                        Text(
                            roiText,
                            color = accentRed,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                        )
                    }
                }

                // RIGHT
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.wrapContentWidth()
                ) {
                    SparkBars(
                        values = bars,
                        color = accentRed,
                        barWidth = 10.dp,
                        barGap = 6.dp,
                        barCorner = 5.dp,
                        modifier = Modifier
                            .width(128.dp)   // 고정 폭으로 깨짐 방지
                            .height(48.dp)
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        profitAmountText,
                        color = accentRed,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                    )
                }
            }
        }
    }
}

@Composable
private fun SparkBars(
    values: List<Float>,
    color: Color,
    barWidth: Dp,
    barGap: Dp,
    barCorner: Dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val w = barWidth.toPx()
        val gap = barGap.toPx()
        val r = barCorner.toPx()
        val hMax = size.height

        values.forEachIndexed { i, v ->
            val x = i * (w + gap)
            val h = v.coerceIn(0f, 1f) * hMax
            drawRoundRect(
                color = color,
                topLeft = androidx.compose.ui.geometry.Offset(x, hMax - h),
                size = androidx.compose.ui.geometry.Size(w, h),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(r, r)
            )
        }
    }
}
