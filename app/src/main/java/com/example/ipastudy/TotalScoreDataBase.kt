package com.example.ipastudy

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ipastudy.model.Score
import com.example.ipastudy.model.TotalScore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(TotalScore::class), version = 1, exportSchema = false)
public abstract class TotalScoreDatabase : RoomDatabase() {

    abstract fun totalScoreDao(): TotalScoreDao

    private class TotalScoreDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var totalScoreDao = database.totalScoreDao()

                    // Delete all content here.
                    totalScoreDao.deleteAll()

                    // Add sample words.
                    //var totalScore = TotalScore("Hello")
                    //wordDao.insert(word)
                    //word = Word("World!")
                    //wordDao.insert(word)

                    // TODO: Add your own words!
                    var totalScore = TotalScore(2)
                    totalScoreDao.insert(totalScore)
                }
            }
        }
    }

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