package com.example.ipastudy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ipastudy.model.MainRepository
import com.example.ipastudy.model.Score

class ScoreViewModel():ViewModel() {

    private val _scores = MutableLiveData<MutableList<Score>>()
    val scores: LiveData<MutableList<Score>> = _scores


    fun setScores(element:Score) {
        _scores.value?.add(element)
    }

    init {
        _scores.value = mutableListOf<Score>()
        val repository = MainRepository()
        repository.getScores().forEach {
            _scores.value?.add(it)
        }
    }
}