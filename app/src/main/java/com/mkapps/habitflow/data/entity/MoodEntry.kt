package com.mkapps.habitflow.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mkapps.habitflow.domain.mood.model.Mood

@Entity(tableName = "mood_entries")
data class MoodEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val mood: Mood,
    val note: String?,
    val timestamp: Long = System.currentTimeMillis()
)