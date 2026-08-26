package com.layane.task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.layane.task.R
import com.layane.task.databinding.FragmentLoginBinding
import com.layane.task.util.initToolbar

class fragment_form_task : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        //initToolbar(binding.toolbar)
        initListener()
    }
    private fun initListener() {
        binding.buttonSave.setOnclickListener{
            validateDate()
        }
    }
    private fun validateDate(){
        val description =binding.editTextdescricao.text.ToString().trim()
        if (description.isNotBlank()){
            Toast.makeText(requireContext(), "Tudo OK!")
        }
    }
}