package com.example.ipastudy.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ipastudy.R
import kotlinx.android.synthetic.main.fragment_hardware_study.*


class HardWareStudyFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_hardware_study, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_hardware_study1.setOnClickListener {
            findNavController().navigate(R.id.hardWareBaseFragment)
        }
        go_hardware_study2.setOnClickListener {
            findNavController().navigate(R.id.hardWareBaseFragment)
        }
    }
}