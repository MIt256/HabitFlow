package com.mkapps.habitflow.data.db

import androidx.room.TypeConverter
import com.mkapps.habitflow.domain.mood.model.Mood

class MoodConverter {
    @TypeConverter
    fun fromMood(mood: Mood): String = mood.name

    @TypeConverter
    fun toMood(name: String): Mood = Mood.valueOf(name)
}
