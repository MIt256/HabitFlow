package com.mkapps.habitflow.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkapps.habitflow.domain.mood.model.Mood
import com.mkapps.habitflow.domain.mood.usecase.AddMoodEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoodViewModel @Inject constructor(
    private val addMoodEntryUseCase: AddMoodEntryUseCase
) : ViewModel() {
    fun saveMood(mood: Mood, note: String?) {
        viewModelScope.launch {
            addMoodEntryUseCase(mood, note)
        }
    }
}