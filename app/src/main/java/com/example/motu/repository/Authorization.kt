package com.example.motu.repository

import javax.inject.Inject

class AuthorizationRepository @Inject constructor() {

    suspend fun getAccessToken(): String {
        return "mock_access_token_123456"
    }
}