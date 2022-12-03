package edu.itvo.quotescelebrities.domain.usecase

import edu.itvo.quotescelebrities.data.model.LoginRequest
import edu.itvo.quotescelebrities.data.remote.UserLoginResponse
import edu.itvo.quotescelebrities.domain.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LoginUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun login(loginRequest: LoginRequest): Flow<UserLoginResponse>? = userRepository.login(loginRequest)
}
