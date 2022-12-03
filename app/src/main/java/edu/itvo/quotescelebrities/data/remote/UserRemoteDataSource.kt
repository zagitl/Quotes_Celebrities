package edu.itvo.quotescelebrities.data.remote

import edu.itvo.quotescelebrities.data.model.LoginRequest
import kotlinx.coroutines.flow.Flow


interface UserRemoteDataSource {
    suspend fun login(loginRequest: LoginRequest): Flow<UserLoginResponse>
}
