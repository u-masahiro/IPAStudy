package com.example.ipastudy.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ipastudy.R
import kotlinx.android.synthetic.main.fragment_hardware_result.*


class HardWareResultFragment:Fragment() {
    private val bundle = arguments
    private var score = 0
    private var totalScoreLabel: TextView? = view?.findViewById(R.id.totalScoreLabel)
    private val  prefs: SharedPreferences = this.requireActivity().getSharedPreferences("quizApp", Context.MODE_PRIVATE)

    override  fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hardware_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultLabel: TextView = view.findViewById(R.id.resultLabel)
        if (bundle != null) {
             score = bundle.getInt("RIGHT_ANSWER_COUNT", 0)
        }
        var totalScore = prefs.getInt("totalScore", 0)
        totalScore += score

        resultLabel.text = "$score/ 5"
        this.totalScoreLabel?.text  = "トータルスコア : $totalScore"

        val editor = prefs.edit()
        editor.putInt("totalScore", totalScore)
        editor.apply()
        base_back_button.setOnClickListener {

        }
    }

}