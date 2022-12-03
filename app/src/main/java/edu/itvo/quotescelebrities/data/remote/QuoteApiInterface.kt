package edu.itvo.quotescelebrities.data.remote

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface QuoteApiInterface {
    @Headers("Content-Type: application/json; charset=utf-8","Accept: */*; charset=utf-8")
    @GET("api/v1/quotes")
    suspend fun getQuotes(@Header("Authorization") token:String): JsonObject



    @POST("api/v1/quotes")
    suspend fun addQuotes(): JsonObject
}