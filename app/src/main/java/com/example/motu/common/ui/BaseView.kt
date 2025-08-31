//package com.example.motu.common.ui
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun BaseView(
//    modifier: Modifier = Modifier,
//    leading: @Composable (() -> Unit)? = null,
//    title: @Composable (() -> Unit)? = null,
//    action: @Composable (() -> Unit)? = null,
//    body: @Composable () -> Unit = {},
//    footer: @Composable () -> Unit = {}
//) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(horizontal = 16.dp)
//    ) {
//        // 📌 Header (기본 높이 36dp)
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(36.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            // Leading 영역 (좌측)
//            Row(
//                modifier = Modifier
//                    .align(Alignment.CenterStart)
//            ) {
//                leading?.invoke()
//            }
//
//            // Title (중앙 정렬)
//            title?.invoke()
//
//            // Action 영역 (우측)
//            Row(
//                modifier = Modifier
//                    .align(Alignment.CenterEnd)
//            ) {
//                action?.invoke()
//            }
//        }
//
//        // 📌 Body (내용)
//        Column(
//            modifier = Modifier
//                .weight(1f)
//                .fillMaxWidth()
//        ) {
//            body()
//        }
//
//        // 📌 Footer
//        Column(
//            modifier = Modifier
//                .wrapContentHeight()
//                .fillMaxWidth()
//        ) {
//            footer()
//        }
//    }
//}
//
