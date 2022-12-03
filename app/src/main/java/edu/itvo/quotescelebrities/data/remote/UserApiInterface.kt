package edu.itvo.quotescelebrities.data.remote

import com.google.gson.JsonObject
import edu.itvo.quotescelebrities.data.model.LoginRequest
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserApiInterface {
    @Headers("Content-Type: application/json; charset=utf-8","Accept: */*; charset=utf-8")
    @POST("api/v1/users/login")
    suspend fun login(@Body requestLogin: LoginRequest): JsonObject

}