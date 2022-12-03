package edu.itvo.quotescelebrities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import edu.itvo.quotescelebrities.domain.usecase.AddQuoteUseCase
import edu.itvo.quotescelebrities.domain.usecase.EditQuoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class QuoteAddViewModel
@Inject constructor(private val addQuoteUseCase: AddQuoteUseCase): ViewModel() {
    private val quoteModelInitial = QuoteModel(id=0, quote = "Solo se que no se nada", author = "Socrates")
    private val _quoteEditMutableStateFlow = MutableStateFlow(quoteModelInitial)
    val quoteModel: StateFlow<QuoteModel> = _quoteEditMutableStateFlow


    fun addQuote(quoteModel: QuoteModel) {

        viewModelScope.launch {
            addQuoteUseCase.addQuote(quoteModel = quoteModel)
        }
    }
}