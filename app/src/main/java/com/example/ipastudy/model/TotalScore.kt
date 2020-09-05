package com.example.ipastudy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "total_score_table")
data class TotalScore (
    @PrimaryKey
    @ColumnInfo(name = "total_score")
    val total_score: Int
)
