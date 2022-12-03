package edu.itvo.quotescelebrities.data.local

import edu.itvo.quotescelebrities.data.remote.QuoteApiResponse
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow

interface QuoteLocalDataSource {
    suspend fun  getQuotes(): Flow<QuoteApiResponse>
    fun  getQuote(quoteId:Int): Flow<QuoteModel>
    fun  getQuoteRandom(): Flow<QuoteModel>

    suspend fun  insertAll(quotes : List<QuoteModel>)
    suspend fun  insert(quoteModel: QuoteModel )
    suspend fun  editQuote(quoteModel: QuoteModel)
}