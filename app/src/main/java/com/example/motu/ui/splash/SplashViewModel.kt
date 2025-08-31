package com.example.motu.ui.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.motu.repository.AuthorizationRepository
import com.example.motu.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val accessTokenRepository: AuthorizationRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _isReady = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> = _isReady

    init {
        viewModelScope.launch {
            try {
                // 1. AccessToken 받아오기 (로그인 기반이면 refresh도 검증)
                val token = accessTokenRepository.getAccessToken()

                // 2. 사용자 정보 가져오기 (optional)
                val userInfo = userRepository.getUserInfo()

                // 3. 최소 로딩 시간 유지
                delay(3000)

                // 4. 준비 완료 → 화면 전환 트리거
                _isReady.value = true
            } catch (e: Exception) {
                // 서버 오류, 네트워크 에러 처리
                Log.e("SplashViewModel", "초기화 실패: ${e.message}")
            }
        }
    }
}
