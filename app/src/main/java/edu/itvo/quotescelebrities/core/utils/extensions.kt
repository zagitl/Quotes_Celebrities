package edu.itvo.quotescelebrities.core.utils

import edu.itvo.quotescelebrities.data.local.entities.QuoteEntity
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import kotlinx.coroutines.flow.*

fun QuoteEntity.toQuoteModel() = QuoteModel(
    id=id,
    quote = quote,
    author = author,
)
fun QuoteModel.toEntity() = QuoteEntity(
    id= id,
    quote = quote,
    author = author,
)

fun List<QuoteModel>.toListQuoteEntity () =
    map {it.toEntity() }

fun List<QuoteEntity>.toListQuoteModel () =
    map {it.toQuoteModel() }