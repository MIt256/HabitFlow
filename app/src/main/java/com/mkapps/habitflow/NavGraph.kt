package com.mkapps.habitflow

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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