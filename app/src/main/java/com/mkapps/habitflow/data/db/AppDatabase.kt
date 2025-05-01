package com.mkapps.habitflow.data.db

import androidx.room.*
import com.mkapps.habitflow.data.entity.MoodEntry

@Database(entities = [MoodEntry::class], version = 1)
@TypeConverters(MoodConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moodEntryDao(): MoodEntryDao
}
