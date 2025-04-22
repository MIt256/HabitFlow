package com.mkapps.habitflow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val settings by viewModel.settings.collectAsState()

    SettingsScreenPreviewContent(
        settings = settings,
        onChangeLanguage = viewModel::changeLanguage,
        onToggleTheme = viewModel::toggleTheme
    )
}

@Composable
fun SettingsScreenPreviewContent(
    settings: AppSettings,
    onChangeLanguage: (String) -> Unit,
    onToggleTheme: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Настройки", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(24.dp))

        Text("Язык приложения:")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            LanguageButton("Русский", selected = settings.language == "ru") {
                onChangeLanguage("ru")
            }
            LanguageButton("English", selected = settings.language == "en") {
                onChangeLanguage("en")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Темная тема")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = settings.darkTheme,
                onCheckedChange = { onToggleTheme() }
            )
        }
    }
}


@Composable
fun LanguageButton(
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primary else Color.LightGray,
            contentColor = if (selected) Color.White else Color.Black
        )
    ) {
        Text(title)
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    val fakeSettings = AppSettings(language = "ru", darkTheme = true)

    SettingsScreenPreviewContent(
        settings = fakeSettings,
        onChangeLanguage = {},
        onToggleTheme = {}
    )
}