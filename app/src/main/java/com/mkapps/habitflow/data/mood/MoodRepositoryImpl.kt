package com.mkapps.habitflow.data.mood

import com.mkapps.habitflow.data.db.MoodEntryDao
import com.mkapps.habitflow.data.entity.MoodEntry
import com.mkapps.habitflow.domain.mood.MoodRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoodRepositoryImpl @Inject constructor(
    private val dao: MoodEntryDao
) : MoodRepository {
    override suspend fun insertMood(entry: MoodEntry) = dao.insertMood(entry)
    override fun getAllMoods(): Flow<List<MoodEntry>> = dao.getAllMoods()
}