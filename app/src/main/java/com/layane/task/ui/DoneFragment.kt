package com.layane.task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.layane.task.R
import com.layane.task.databinding.FragmentDoingBinding
import com.layane.task.databinding.FragmentDoneBinding
import com.layane.task.databinding.FragmentHomeBinding

class DoneFragment : Fragment() {
    private var _binding: FragmentDoneBinding? = null
    private val biding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return biding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}