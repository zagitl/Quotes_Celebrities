package edu.itvo.quotescelebrities.presentation.view

import android.app.Dialog
import android.view.Window
import androidx.fragment.app.Fragment
import edu.itvo.quotescelebrities.databinding.DialogLayoutBinding

class CustomAlert {
    private lateinit var binding: DialogLayoutBinding
    fun showDialog(fragment:  Fragment?, msg: String?) {
        binding =  DialogLayoutBinding.inflate(fragment!!.layoutInflater)
        val dialog = fragment.context?.let { Dialog(it) }
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(binding.root)
        binding.message.text= msg
        binding.btnOK.setOnClickListener {
            dialog.dismiss()

        }
        dialog.show()
    }
}