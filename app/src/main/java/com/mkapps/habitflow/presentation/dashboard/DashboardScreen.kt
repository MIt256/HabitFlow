package com.mkapps.habitflow.presentation.dashboard

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mkapps.habitflow.R
import com.mkapps.habitflow.domain.mood.model.Mood
import com.mkapps.habitflow.domain.mood.model.Mood.ANGRY
import com.mkapps.habitflow.domain.mood.model.Mood.EXCITED
import com.mkapps.habitflow.domain.mood.model.Mood.HAPPY
import com.mkapps.habitflow.domain.mood.model.Mood.NEUTRAL
import com.mkapps.habitflow.domain.mood.model.Mood.SAD
import com.mkapps.habitflow.presentation.viewmodel.MoodViewModel

@Composable
fun DashboardScreen(
    navController: NavController,
    moodViewModel: MoodViewModel = hiltViewModel()
) {

    var selectedMood by remember { mutableStateOf<Mood?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        IconButton(
            onClick = { navController.navigate("settings") },
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Icon(Icons.Default.Settings, contentDescription = "Settings")
        }

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .animateContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.dashboard_screen_hello_lable),
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            if (selectedMood != null) {
                TodayMoodCard(selectedMood)
                moodViewModel.saveMood(selectedMood!!,note = null)
            }

            Spacer(modifier = Modifier.height(16.dp))

            MoodSelector(onMoodSelected = { selectedMood = it })

            Spacer(modifier = Modifier.height(32.dp))

            DashboardButton(
                text = stringResource(R.string.dashboard_screen_add_mood_button),
                icon = Icons.Default.Favorite
            ) {
                //todo not impl
                //navController.navigate("mood_entry")
            }

            Spacer(modifier = Modifier.height(16.dp))

            DashboardButton(
                text = stringResource(R.string.dashboard_screen_my_habits_button),
                icon = Icons.Default.CheckCircle
            ) {
                navController.navigate("habits")
            }

            Spacer(modifier = Modifier.height(16.dp))

            DashboardButton(
                text = stringResource(R.string.dashboard_screen_mood_history_button),
                icon = Icons.Default.Refresh
            ) {
                navController.navigate("journal")
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}


@Composable
fun TodayMoodCard(selectedMood: Mood?) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.dashboard_screen_todays_mood_lable),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                if (selectedMood != null) {
                    Text(
                        text = selectedMood.emoji,
                        fontSize = 36.sp
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = when (selectedMood) {
                            SAD -> stringResource(R.string.mood_sad)
                            ANGRY -> stringResource(R.string.mood_angry)
                            NEUTRAL -> stringResource(R.string.mood_neutral)
                            HAPPY -> stringResource(R.string.mood_happy)
                            EXCITED -> stringResource(R.string.mood_excited)
                        },
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Composable
fun MoodSelector(onMoodSelected: (Mood) -> Unit) {
    val moods = Mood.entries.toTypedArray()

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
    ) {
        items(moods.size) { index ->
            val mood = moods[index]
            MoodButton(mood = mood, onClick = { onMoodSelected(mood) })
        }
    }
}

@Composable
fun MoodButton(mood: Mood, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = mood.emoji,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(rememberNavController())
}
