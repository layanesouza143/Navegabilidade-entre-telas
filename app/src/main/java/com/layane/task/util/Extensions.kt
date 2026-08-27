package com.layane.task.util

import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.layane.task.R
import com.layane.task.databinding.BottomSheetBinding

fun Fragment.initToolbar(toolbar: Toolbar){
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title=""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled((true))
    toolbar.setNavigationOnClickListener{
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}
fun Fragment.showBottonSheet(
    titleDiaLog: Int? = null,
    titleButton: Int?= null,
    mensage: Int,
    onClick:()->Unit={}
){
    val bottomSheetDialog = BottomSheetDialog(requireContext())
    val binding: BottomSheetBinding =
        BottomSheetBinding.inflate(layoutInflater,null,false)

    binding.textviewTitle.text=getText(titleDiaLog?:R.string.text_title_warning)
    binding.textviewMessage.text=getText(Message)
    binding.buttonok.text = getText(titleButton?:R.string.text_button_warning)
    binding.buttonok.setOnClickListener{
        onClick()
        bottomSheetDialog.dismiss()
    }
}