package edu.itvo.quotescelebrities.data.remote

import com.google.gson.Gson
import com.google.gson.JsonObject
import edu.itvo.quotescelebrities.data.model.LoginRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class UserRemoteDataSourceImpl @Inject constructor(private  val api:UserApiInterface):UserRemoteDataSource {
    override suspend fun login(loginRequest: LoginRequest): Flow<UserLoginResponse> {
        val jsonObj: JsonObject =  api.login(loginRequest)
        val userLoginResponse = Gson().fromJson(jsonObj, UserLoginResponse::class.java)
        return flow{emit(userLoginResponse)}
    }
}