package com.example.ipastudy.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipastudy.R
import com.example.ipastudy.viewModel.ScoreViewModel
import kotlinx.android.synthetic.main.fragment_hardware_result.*
import androidx.lifecycle.Observer

class HardWareResultFragment:Fragment() {

    //private val viewModel:ScoreViewModel by activityViewModels()
    private lateinit var adapter: ResultAdapter
    private val viewModel: ScoreViewModel by activityViewModels()
    //private var score = 0
    //private var totalScoreLabel: TextView? = view?.findViewById(R.id.totalScoreLabel)

    override  fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hardware_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerViewの取得
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)


        //val resultLabel: TextView = view.findViewById(R.id.item_result_right_answer)
        //var  prefs: SharedPreferences = this.requireActivity().getSharedPreferences("quizApp", Context.MODE_PRIVATE)

        // LayoutManagerの設定
        recycler_view.layoutManager = LinearLayoutManager(context)

        // ExistListAdapterの生成と設定
        viewModel.scores.observe(viewLifecycleOwner, Observer{
            adapter = ResultAdapter(it)
            recyclerView.adapter = adapter
        })

        base_back_button.setOnClickListener {
            findNavController().navigate(R.id.baseFragment)
        }

        //score = arguments?.getInt("RIGHT_ANSWER_COUNT", 0) ?: 0

        /*var totalScore = prefs.getInt("totalScore", 0)
        totalScore += score

        resultLabel.text = "$score/2"
        this.totalScoreLabel?.text  = "トータルスコア : $totalScore"

        val editor = prefs.edit()
        editor.putInt("totalScore", totalScore)
        editor.apply()
        base_back_button.setOnClickListener {
            findNavController().navigate(R.id.hardWareBaseFragment)
        }*/
    }

}