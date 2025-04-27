package com.mkapps.habitflow.domain.settings

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val settingsFlow: Flow<AppSettings>
    suspend fun setLanguage(code: String)
    suspend fun setDarkTheme(enabled: Boolean)
}