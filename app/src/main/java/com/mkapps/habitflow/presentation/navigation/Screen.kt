package com.mkapps.habitflow.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector? = null) {
    object Dashboard : Screen("dashboard", "Главная", Icons.Default.Home)
    object Habits : Screen("habits", "Привычки", Icons.Default.Check)
    object Journal : Screen("journal", "Журнал", Icons.Default.Menu)
    object Analytics : Screen("analytics", "Аналитика", Icons.Default.AccountCircle)
    object AICoach : Screen("aicoach", "ИИКоуч", Icons.Default.Face)

    object Settings : Screen("settings", "Settings")
    object MoodEntry : Screen("mood_entry", "Settings")
}
