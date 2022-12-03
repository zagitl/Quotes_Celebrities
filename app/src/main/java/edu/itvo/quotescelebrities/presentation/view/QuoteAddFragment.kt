package edu.itvo.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import edu.itvo.quotescelebrities.R
import edu.itvo.quotescelebrities.databinding.FragmentQuoteAddBinding
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import edu.itvo.quotescelebrities.presentation.viewmodel.QuoteAddViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteAddFragment : Fragment() {
    private lateinit var binding: FragmentQuoteAddBinding
    private val quoteAddViewModel: QuoteAddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuoteAddBinding.inflate(inflater, container, false)
        val root: View = binding.root
        with(binding) {
            btnSave.setOnClickListener {
                val quoteModel= QuoteModel(
                    id = etId.text.toString().toInt(),
                    quote = etQuote.text.toString(),
                    author = etAuthor.text.toString(),
                )
                lifecycleScope.launch(Dispatchers.IO) {
                    quoteAddViewModel.addQuote(quoteModel)
                }
                val alert = CustomAlert()
                alert.showDialog(this@QuoteAddFragment.parentFragment, getString(R.string.saved))

            }
        }
        return root
    }

}