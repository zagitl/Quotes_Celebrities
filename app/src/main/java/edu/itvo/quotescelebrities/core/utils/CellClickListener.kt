package edu.itvo.quotescelebrities.core.utils

import edu.itvo.quotescelebrities.domain.model.QuoteModel


interface CellClickListener {
    fun onCellClickListener(quoteModel: QuoteModel)
}