package com.mkapps.habitflow

import android.os.Bundle
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

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val settingsViewModel: SettingsViewModel by viewModels()

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

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreenContent(darkTheme = true)
}