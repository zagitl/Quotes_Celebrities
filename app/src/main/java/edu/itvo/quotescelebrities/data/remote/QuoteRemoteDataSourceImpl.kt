package edu.itvo.quotescelebrities.data.remote

import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QuoteRemoteDataSourceImpl @Inject constructor(private  val api:QuoteApiInterface):QuoteRemoteDataSource {
    override suspend fun getQuotes(token: String ): Flow<QuoteApiResponse> {
        val jsonObj: JsonObject =  api.getQuotes(token)
        val quoteApiResponse = Gson().fromJson(jsonObj, QuoteApiResponse::class.java)

        return flow{emit(quoteApiResponse)}
    }
}