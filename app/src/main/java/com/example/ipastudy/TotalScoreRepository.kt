package com.example.ipastudy

import androidx.lifecycle.LiveData
import com.example.ipastudy.model.TotalScore

class TotalScoreRepository(private val totalScoreDao: TotalScoreDao) {
    val allWords : LiveData<MutableList<TotalScore>> = totalScoreDao.getAlphabetizedWords()

    suspend fun insert(totalScore: TotalScore){
        totalScoreDao.insert(totalScore)
    }
}