package edu.itvo.quotescelebrities.domain.usecase

import edu.itvo.quotescelebrities.data.remote.QuoteApiResponse
import edu.itvo.quotescelebrities.domain.QuoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun getQuotes(token: String): Flow<QuoteApiResponse?> = quoteRepository.getQuotes(token)

}