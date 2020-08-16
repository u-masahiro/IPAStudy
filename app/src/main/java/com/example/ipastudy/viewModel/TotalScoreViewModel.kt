package com.example.ipastudy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ipastudy.model.MainRepository
import com.example.ipastudy.model.TotalScore


class TotalScoreViewModel():ViewModel() {

    private val _totalScores = MutableLiveData<MutableList<TotalScore>>()
    val totalScore: LiveData<MutableList<TotalScore>> = _totalScores

    fun setTotalScore(element:TotalScore) {
        _totalScores.value?.add(element)
    }

    init {
        _totalScores.value = mutableListOf<TotalScore>()
        val repository = MainRepository()
        repository.getTotalScores().forEach {
            _totalScores.value?.add(it)
        }
    }
}