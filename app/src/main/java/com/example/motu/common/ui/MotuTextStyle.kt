package com.example.motu.common.ui

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.motu.R

object MotuFont {
    val pretendard = FontFamily(
        Font(R.font.pretendard, FontWeight.Normal),
    )
}

object MotuTextStyle {
    private val defaultFontFamily = MotuFont.pretendard

    fun title(
        fontSize: TextUnit?,
        fontWeight: FontWeight?,
        color: Color?
    ): TextStyle {
        return TextStyle(
            fontFamily = MotuFont.pretendard,
            fontWeight = fontWeight ?: FontWeight.Bold,
            fontSize = fontSize ?: 20.sp,
            color = color ?: Color.Black
        )
    }

    fun body(
        fontSize: TextUnit = 16.sp,
        fontWeight: FontWeight = FontWeight.Normal,
        color: Color = Color.Black,
        align: TextAlign = TextAlign.Center
    ): TextStyle {
        return TextStyle(
            fontFamily = MotuFont.pretendard,
            fontWeight = fontWeight,
            fontSize = fontSize,
            color = color,
            textAlign = align
        )
    }

    fun caption(
        fontSize: TextUnit?,
        color: Color?
    ): TextStyle {
        return TextStyle(
            fontFamily = MotuFont.pretendard,
            fontWeight = FontWeight.Normal,
            fontSize = fontSize ?: 12.sp,
            color = color ?: Color.Gray
        )
    }
}