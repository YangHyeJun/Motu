package com.example.motu.common.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motu.R

@Composable
fun ListBox(
    title: String,
    showMoreButton: Boolean = false,
    moreButtonOnClick: () -> Unit = {},
    resultTitle: String? = null,
    resultContent: String? = null,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(14.dp),
    borderWidth: Dp = 1.5.dp,
    borderColors: List<Color> = listOf(Color(0xFFE6ECF9), Color(0xFFF6F8FA)),
    headerPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    bodyPadding: PaddingValues = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
    footerPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = borderWidth,
                brush = Brush.linearGradient(borderColors),
                shape = shape
            )
            .background(Color.White, shape)
            .clip(shape)
    ) {
        Column {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(headerPadding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                    color = Color(0xFF0F172A),
                    modifier = Modifier.weight(1f)
                )
                if (showMoreButton) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable(onClick = moreButtonOnClick)
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    ) {
                        val textStyle = MotuTextStyle.body(fontSize = 13.sp)
                        val textColor = Color(0xFF717182)

                        Text(
                            text = "더보기",
                            style = textStyle,
                            color = textColor
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Image(
                            painter = painterResource(id = R.drawable.icon_more_button),
                            contentDescription = "더보기 아이콘",
                            modifier = Modifier.size(textStyle.fontSize.value.dp),
                            colorFilter = ColorFilter.tint(textColor)
                        )
                    }
                }
            }

            HorizontalDivider(color = Color(0xFFE5E7EB))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bodyPadding),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                content = content
            )

            if (resultTitle != null || resultContent != null) {
                HorizontalDivider(color = Color(0xFFE5E7EB))
                Box (
                    modifier = Modifier.background(color = Color(0xFFF9F9FA))
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(footerPadding),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = resultTitle.orEmpty(),
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF64748B)
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = resultContent.orEmpty(),
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                            color = Color(0xFF0F172A),
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }
}
