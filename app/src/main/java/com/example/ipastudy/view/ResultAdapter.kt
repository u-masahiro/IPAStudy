package com.example.ipastudy.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ipastudy.R
import com.example.ipastudy.model.Score

class ResultAdapter(private val scoreList: MutableList<Score>): RecyclerView.Adapter<ResultAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val resultRightAnswer: TextView = view.findViewById(R.id.item_result_right_answer)
        //val resultTotalScore: TextView = view.findViewById(R.id.item_result_total_score)
    }

    // レイアウトの設定
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(view)
    }

    // Viewの設定
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val score = scoreList[position]

        viewHolder.resultRightAnswer.text = score.right_answer.toString()
       // viewHolder.resultTotalScore.text = score.total_score.toString()
    }
    // 表示数を返す
    override fun getItemCount() = scoreList.size
}