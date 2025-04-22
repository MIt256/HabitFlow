package com.mkapps.habitflow

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val settingsFlow: Flow<AppSettings>
    suspend fun setLanguage(code: String)
    suspend fun setDarkTheme(enabled: Boolean)
}