package com.mkapps.habitflow.domain.mood.usecase

import com.mkapps.habitflow.domain.mood.model.Mood
import com.mkapps.habitflow.data.entity.MoodEntry
import com.mkapps.habitflow.domain.mood.MoodRepository
import javax.inject.Inject

class AddMoodEntryUseCase @Inject constructor(
    private val moodRepository: MoodRepository
) {
    suspend operator fun invoke(mood: Mood, note: String?) {
        moodRepository.insertMood(MoodEntry(mood = mood, note = note))
    }
}