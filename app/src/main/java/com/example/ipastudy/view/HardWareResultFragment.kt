package com.example.ipastudy.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipastudy.R
import com.example.ipastudy.viewModel.ScoreViewModel
import kotlinx.android.synthetic.main.fragment_hardware_result.*
import androidx.lifecycle.Observer
import com.example.ipastudy.viewModel.TotalScoreViewModel

class HardWareResultFragment:Fragment() {

    private lateinit var adapter: ResultAdapter
    private lateinit var totalScoreAdapter: TotalScoreAdapter

    private val viewModel: ScoreViewModel by activityViewModels()
    private val totalScoreViewModel:TotalScoreViewModel by activityViewModels()

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
        val totalScoreRecyclerView = view.findViewById<RecyclerView>(R.id.total_score_recycler_view)

        // LayoutManagerの設定
        recycler_view.layoutManager = LinearLayoutManager(context)
        total_score_recycler_view.layoutManager = LinearLayoutManager(context)


        // ExistListAdapterの生成と設定
        viewModel.scores.observe(viewLifecycleOwner, Observer{
            adapter = ResultAdapter(it)
            recyclerView.adapter = adapter
        })

        totalScoreViewModel.totalScore.observe(viewLifecycleOwner, Observer{
            totalScoreAdapter = TotalScoreAdapter(it)
            if (totalScoreRecyclerView != null) totalScoreRecyclerView.adapter = totalScoreAdapter
        })

        base_back_button.setOnClickListener {
            findNavController().navigate(R.id.baseFragment)
        }

    }

}