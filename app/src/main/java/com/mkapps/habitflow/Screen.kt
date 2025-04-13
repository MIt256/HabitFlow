package com.mkapps.habitflow

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Dashboard : Screen("dashboard", "Главная", Icons.Default.Home)
    object Habits : Screen("habits", "Привычки", Icons.Default.Check)
    object Journal : Screen("journal", "Журнал", Icons.Default.Menu)
    object Analytics : Screen("analytics", "Аналитика", Icons.Default.AccountCircle)
    object Coach : Screen("coach", "Коуч", Icons.Default.Face)
}
