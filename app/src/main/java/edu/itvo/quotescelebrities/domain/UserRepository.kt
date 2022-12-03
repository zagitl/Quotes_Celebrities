package edu.itvo.quotescelebrities.domain

import edu.itvo.quotescelebrities.data.model.LoginRequest
import edu.itvo.quotescelebrities.data.remote.UserLoginResponse

import kotlinx.coroutines.flow.Flow

interface  UserRepository {
    suspend fun login(loginRequest: LoginRequest): Flow<UserLoginResponse>?

}