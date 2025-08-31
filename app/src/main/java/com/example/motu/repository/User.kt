package com.example.motu.repository

import javax.inject.Inject

class UserRepository @Inject constructor() {

    suspend fun getUserInfo(): String {
        return "mock_access_token_123456"
    }
}