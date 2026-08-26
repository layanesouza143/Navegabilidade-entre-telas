package com.layane.task.util

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

fun Fragment.initToolbar(Toolbar: Toolbar){
    (activity as AppCompatActivity).setSupportActionBar(Toolbar)
    (activity as AppCompatActivity).title=""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled((true))
    Toolbar.setNavigationOnClickListener{
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}