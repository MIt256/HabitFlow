package com.mkapps.habitflow

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : SettingsRepository {

    private val dataStore = SettingsDataStore(context)

    override val settingsFlow: Flow<AppSettings>
        get() = dataStore.settingsFlow

    override suspend fun setLanguage(language: String) {
        dataStore.setLanguage(language)
    }

    override suspend fun setDarkTheme(enabled: Boolean) {
        dataStore.toggleTheme()
    }
}
