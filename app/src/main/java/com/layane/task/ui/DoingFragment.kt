package com.layane.task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.layane.task.R
import com.layane.task.databinding.FragmentDoingBinding
import com.layane.task.databinding.FragmentHomeBinding

class DoingFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
           return inflater.inflate(R.layout.fragment_doing,container,false)
        }

    }