package com.mkapps.habitflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val repo: SettingsRepository) :
    ViewModel() {
    val settings = repo.settingsFlow.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        AppSettings("en", false)
    )

    fun changeLanguage(code: String) {
        viewModelScope.launch { repo.setLanguage(code) }
    }

    fun toggleTheme() {
        viewModelScope.launch {
            repo.setDarkTheme(!settings.value.darkTheme)
        }
    }
}
