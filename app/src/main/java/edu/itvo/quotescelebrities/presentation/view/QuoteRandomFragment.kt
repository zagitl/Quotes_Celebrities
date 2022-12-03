package edu.itvo.quotescelebrities.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import edu.itvo.quotescelebrities.databinding.FragmentQuoteRandomBinding
import edu.itvo.quotescelebrities.presentation.viewmodel.QuoteRandomViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteRandomFragment : Fragment() {

    private lateinit var binding: FragmentQuoteRandomBinding
    private val quoteRandomViewModel: QuoteRandomViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuoteRandomBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //----------------------------
        quoteRandomViewModel.randomQuote()
        observer()
        binding.viewContainer.setOnClickListener {
            quoteRandomViewModel.randomQuote()
        }
        return root
    }

    private fun observer(){
        lifecycleScope.launch {
            quoteRandomViewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text= it.author
            }
        }
    }


}