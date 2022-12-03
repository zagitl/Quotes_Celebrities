package edu.itvo.quotescelebrities.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import edu.itvo.quotescelebrities.R
import edu.itvo.quotescelebrities.databinding.FragmentQuoteEditBinding
import edu.itvo.quotescelebrities.domain.model.QuoteModel
import edu.itvo.quotescelebrities.presentation.viewmodel.QuoteEditViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteEditFragment : Fragment() {
    private lateinit var binding: FragmentQuoteEditBinding
    private val quoteEditViewModel: QuoteEditViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etId.setText(arguments?.getInt("id",0).toString())
        binding.etQuote.setText(arguments?.getString("quote","").toString())
        binding.etAuthor.setText(arguments?.getString("author","").toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuoteEditBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //----------------------------
        with(binding) {
            btnSave.setOnClickListener {
                val quoteModel= QuoteModel(
                    id = etId.text.toString().toInt(),
                    quote = etQuote.text.toString(),
                    author = etAuthor.text.toString(),
                )
                lifecycleScope.launch(Dispatchers.IO) {
                    quoteEditViewModel.editQuote(quoteModel)
                }
                val alert = CustomAlert()
                alert.showDialog(this@QuoteEditFragment.parentFragment, getString(R.string.saved))
                activity?.onBackPressed()
            }
        }
        return root
    }

}