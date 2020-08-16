package com.example.ipastudy.model

class MainRepository {
    fun getScores( ): List<Score> =
        scores

    fun getTotalScores( ):List<TotalScore> = totalScores

    companion object {
        private val scores = listOf<Score>(
        )
        private val totalScores = listOf<TotalScore>(
        )
    }
}