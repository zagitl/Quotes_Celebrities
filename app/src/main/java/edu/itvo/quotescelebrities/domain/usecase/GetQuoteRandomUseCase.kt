package edu.itvo.quotescelebrities.domain.usecase

import edu.itvo.quotescelebrities.domain.QuoteRepository
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteRandomUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository) {
    suspend fun getQuoteRandom(): Flow<QuoteModel> = quoteRepository.getQuoteRandom()

}