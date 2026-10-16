package com.layane.task.util

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.layane.task.R
import com.layane.task.databinding.BottomSheetBinding

fun Fragment.initToolbar(toolbar: Toolbar) {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}

fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: String? = null,
    onClick: () -> Unit = {},
    mensage: String
) {
    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.bottomSheetDiaLog)
    val binding = BottomSheetBinding.inflate(layoutInflater, null, false)

    binding.textviewTitle.text = getString(titleDialog ?: R.string.text_title_warning)
    binding.textviewMessage.text = message ?: ""
    binding.buttonok.text = getString(titleButton ?: R.string.text_button_warning)

    binding.buttonok.setOnClickListener {
        onClick()
        bottomSheetDialog.dismiss()
    }

    bottomSheetDialog.setContentView(binding.root)
    bottomSheetDialog.show()
}