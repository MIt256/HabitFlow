package com.mkapps.habitflow.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mkapps.habitflow.presentation.analytics.AnalyticsScreen
import com.mkapps.habitflow.presentation.coach.CoachScreen
import com.mkapps.habitflow.presentation.dashboard.DashboardScreen
import com.mkapps.habitflow.presentation.habits.HabitsScreen
import com.mkapps.habitflow.presentation.jornal.JournalScreen
import com.mkapps.habitflow.presentation.dashboard.MoodEntryScreen
import com.mkapps.habitflow.presentation.settings.SettingsScreen
import com.mkapps.habitflow.presentation.settings.SettingsViewModel

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route,
        modifier = modifier
    ) {
        //bottom navigation items
        composable(Screen.Dashboard.route) { DashboardScreen(navController) }
        composable(Screen.Habits.route) { HabitsScreen(navController) }
        composable(Screen.Journal.route) { JournalScreen(navController) }
        composable(Screen.Analytics.route) { AnalyticsScreen(navController) }
        composable(Screen.AICoach.route) { CoachScreen(navController) }
        //other screens
        composable(Screen.MoodEntry.route) { MoodEntryScreen(navController) }
        composable(Screen.Settings.route) {
            val viewModel: SettingsViewModel = hiltViewModel()
            SettingsScreen(navController, viewModel)
        }
    }
}