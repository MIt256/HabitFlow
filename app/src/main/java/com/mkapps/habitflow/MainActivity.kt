package com.mkapps.habitflow

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.mkapps.habitflow.ui.theme.HabitFlowTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.getValue
import com.mkapps.habitflow.util.LocaleUtils
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val settingsViewModel: SettingsViewModel by viewModels()

    override fun attachBaseContext(newBase: Context) {
        val dataStore = SettingsDataStore(newBase)
        val contextWithLang = runBlocking {
            val lang = dataStore.getLanguage()
            LocaleUtils.applyLocale(newBase, lang)
        }
        super.attachBaseContext(contextWithLang)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val settings by settingsViewModel.settings.collectAsState()
            MainScreenContent(darkTheme = settings.darkTheme)
        }
    }

}

@Composable
fun MainScreenContent(darkTheme: Boolean) {
    HabitFlowTheme(darkTheme = darkTheme) {
        MainScreen()
    }
}

fun restartApp(context: Context) {
    val intent = Intent(context, MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreenContent(darkTheme = true)
}