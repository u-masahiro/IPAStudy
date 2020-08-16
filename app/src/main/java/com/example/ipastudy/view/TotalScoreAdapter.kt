package com.example.ipastudy.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ipastudy.R
import com.example.ipastudy.model.TotalScore

class TotalScoreAdapter(private val totalScoreList: MutableList<TotalScore>): RecyclerView.Adapter<TotalScoreAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val resultTotalScore: TextView = view.findViewById(R.id.item_total_score_text_view)
        }

        // レイアウトの設定
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.total_score_list_item, viewGroup, false)
            return ViewHolder(view)
        }

        // Viewの設定
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            val score = totalScoreList[position]
            viewHolder.resultTotalScore.text = score.total_score.toString()
        }
        // 表示数を返す
        override fun getItemCount() = totalScoreList.size
}
