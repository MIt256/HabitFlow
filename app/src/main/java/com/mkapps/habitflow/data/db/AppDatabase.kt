package com.mkapps.habitflow.data.db

import android.content.Context
import androidx.room.*
import com.mkapps.habitflow.data.entity.MoodEntry

@Database(entities = [MoodEntry::class], version = 1)
@TypeConverters(MoodConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moodEntryDao(): MoodEntryDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "habitflow_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
