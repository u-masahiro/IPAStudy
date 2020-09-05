package com.example.ipastudy.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.ipastudy.TotalScoreDatabase
import com.example.ipastudy.TotalScoreRepository
import com.example.ipastudy.model.MainRepository
import com.example.ipastudy.model.TotalScore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TotalScoreViewModel(application: Application):AndroidViewModel(application) {

    private val _totalScores = MutableLiveData<MutableList<TotalScore>>()
    val totalScore: LiveData<MutableList<TotalScore>> = _totalScores
    private val repository:TotalScoreRepository
    val allWords:LiveData<MutableList<TotalScore>>

    fun setTotalScore(element:TotalScore) {
        _totalScores.value?.add(element)
    }

    init {
        val totalScoreDao = TotalScoreDatabase.getDatabase(application).totalScoreDao()
        repository = TotalScoreRepository(totalScoreDao)
        allWords = repository.allWords
        _totalScores.value = mutableListOf<TotalScore>()
    }

    fun insert(totalScore:TotalScore)=viewModelScope.launch(Dispatchers.IO){
        repository.insert(totalScore)
    }
}