package com.example.ipastudy

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ipastudy.model.TotalScore

@Dao
interface TotalScoreDao {

    @Query("SELECT * from total_score_table ORDER BY total_score ASC")
    fun getAlphabetizedWords(): LiveData<MutableList<TotalScore>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(totalScore: TotalScore)

    @Query("DELETE FROM total_score_table")
    suspend fun deleteAll()
}