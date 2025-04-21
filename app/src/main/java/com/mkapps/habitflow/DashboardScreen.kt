package com.mkapps.habitflow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Главная страница")
        Button(onClick = { navController.navigate("mood_entry") }) {
            Text("Добавить настроение")
        }
    }
}
//todo
@Composable
fun MoodEntryScreen(navController: NavController) {
    Text("Экран записи настроения")
}

@Preview
@Composable
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())
}


