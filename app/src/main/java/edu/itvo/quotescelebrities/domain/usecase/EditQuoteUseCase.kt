package edu.itvo.quotescelebrities.domain.usecase

import edu.itvo.quotescelebrities.domain.QuoteRepository
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import javax.inject.Inject


class EditQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    suspend fun editQuote(quoteModel: QuoteModel) =
        quoteRepository.editQuote(quoteModel)

}
