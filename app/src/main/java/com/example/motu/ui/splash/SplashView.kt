package com.example.motu.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.motu.R
import com.example.motu.common.ui.MotuTextStyle

@Composable
fun SplashView(
    onSplashFinished: () -> Unit
) {
    val viewModel: SplashViewModel = hiltViewModel()
    val isReady by viewModel.isReady.collectAsState()

    LaunchedEffect(isReady) {
        if (isReady) {
            onSplashFinished()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) { // 전체 화면을 채우는 Box 추가
        Image(
            painter = painterResource(id = R.drawable.splash_background),
            contentDescription = null,
            contentScale = ContentScale.Crop, // 배경에 꽉 채우기
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally // 자식 요소들의 가로 정렬은 중앙으로 유지
        ) {
            // 상단 컨텐츠 (로고 및 앱 이름)
            Column(
                modifier = Modifier.weight(1f), // 남은 공간을 모두 차지하도록 weight 설정
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash_chart_and_coin),
                    contentDescription = "차트 아이콘",
                    modifier = Modifier.size(76.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "모두투자",
                    style = MotuTextStyle.title(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "EVERYONE INVEST",
                    style = MotuTextStyle.body(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF1CDD8C)
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "모두를 위한 모의 투자",
                    style = MotuTextStyle.body(
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFD0D0D0)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "지금, 당신의 투자 감각을\n테스트해 보세요",
                    style = MotuTextStyle.body(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFD0D0D0),
                        align = TextAlign.Center
                    )
                )
            }

            // 하단 텍스트
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "앱을 시작하는 중...",
                    style = MotuTextStyle.body(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        align = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Powered by 한국투자증권 OpenAPI",
                    style = MotuTextStyle.body(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0XFFD0D0D0),
                        align = TextAlign.Center
                    )
                )
            }
        }
    }
}