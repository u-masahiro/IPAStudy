package com.example.ipastudy

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ipastudy.model.TotalScore

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(TotalScore::class), version = 1, exportSchema = false)
public abstract class TotalScoreDatabase : RoomDatabase() {

    abstract fun totalScoreDao(): TotalScoreDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: TotalScoreDatabase? = null

        fun getDatabase(context: Context): TotalScoreDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TotalScoreDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}