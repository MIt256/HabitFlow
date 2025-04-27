package com.mkapps.habitflow.presentation.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkapps.habitflow.app.restartApp
import com.mkapps.habitflow.domain.settings.AppSettings
import com.mkapps.habitflow.domain.settings.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    fun toggleTheme() {
        viewModelScope.launch {
            repo.setDarkTheme(!settings.value.darkTheme)
        }
    }

    fun changeLanguage(code: String, context: Context) {
        viewModelScope.launch {
            repo.setLanguage(code)
            delay(100)//time to save
            restartApp(context)
        }
    }
}
