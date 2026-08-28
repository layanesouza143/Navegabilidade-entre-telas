package com.layane.task.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.layane.task.R
import com.layane.task.databinding.FragmentLoginBinding
import com.layane.task.databinding.FragmentRecoverAccountBinding
import com.layane.task.util.initToolbar
import com.layane.task.util.showBottonSheet


class RecoverAccountFragment : Fragment() {
    private var _binding: FragmentRecoverAccountBinding? =null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListeners()
    }

    private fun initListeners() {
        binding.buttonEntrar.setOnClickListener {
            validateData()
        }
    }
    private fun validateData() {
        val email = binding.editextEmail.text.toString().trim()

        if (email.isNotBlank()) {
            Toast.makeText(requireContext(), "Tudo Ok!", Toast.LENGTH_SHORT).show()
        } else {
            showBottonSheet(mensage = getString(R.string.password_empty))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}