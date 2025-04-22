package com.mkapps.habitflow

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsDataStore(private val context: Context) {

    private object PreferencesKeys {
        val LANGUAGE = stringPreferencesKey("language")
        val DARK_THEME = booleanPreferencesKey("dark_theme")
    }

    val settingsFlow: Flow<AppSettings> = context.dataStore.data
        .map { preferences ->
            AppSettings(
                language = preferences[PreferencesKeys.LANGUAGE] ?: "ru",
                darkTheme = preferences[PreferencesKeys.DARK_THEME] ?: false
            )
        }

    suspend fun setLanguage(language: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.LANGUAGE] = language
        }
    }

    suspend fun toggleTheme() {
        context.dataStore.edit { preferences ->
            val current = preferences[PreferencesKeys.DARK_THEME] ?: false
            preferences[PreferencesKeys.DARK_THEME] = !current
        }
    }
}