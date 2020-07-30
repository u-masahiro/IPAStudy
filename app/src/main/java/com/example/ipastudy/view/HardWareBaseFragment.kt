package com.example.ipastudy.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ipastudy.R
import kotlinx.android.synthetic.main.fragment_hardware_base.*

class HardWareBaseFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_hardware_base, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_hardware_study.setOnClickListener {
            findNavController().navigate(R.id.hardWareStudyFragment)
        }
        go_hardware_question.setOnClickListener {
            findNavController().navigate(R.id.hardWareQuestionFragment)
        }
    }
}