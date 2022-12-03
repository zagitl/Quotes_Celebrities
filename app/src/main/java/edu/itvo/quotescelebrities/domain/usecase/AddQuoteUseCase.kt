package edu.itvo.quotescelebrities.domain.usecase


import edu.itvo.quotescelebrities.domain.QuoteRepository
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import javax.inject.Inject



class AddQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository) {
    suspend fun addQuote(quoteModel: QuoteModel) =
        quoteRepository.addQuote(quoteModel)
}
