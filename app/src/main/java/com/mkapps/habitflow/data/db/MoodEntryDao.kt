package com.mkapps.habitflow.data.db

import androidx.room.*
import com.mkapps.habitflow.data.entity.MoodEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface MoodEntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMood(moodEntry: MoodEntry)

    @Query("SELECT * FROM mood_entries ORDER BY timestamp DESC")
    fun getAllMoods(): Flow<List<MoodEntry>>

    @Query("DELETE FROM mood_entries")
    suspend fun clearAll()
}