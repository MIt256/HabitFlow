package com.mkapps.habitflow.domain.mood

import com.mkapps.habitflow.data.entity.MoodEntry
import kotlinx.coroutines.flow.Flow

interface MoodRepository {
    suspend fun insertMood(entry: MoodEntry)
    fun getAllMoods(): Flow<List<MoodEntry>>
}