package com.mkapps.habitflow.domain.mood.model

enum class Mood {
    SAD, ANGRY, NEUTRAL, HAPPY, EXCITED;

    val emoji: String
        get() = when (this) {
            SAD -> "😔"
            ANGRY -> "😡"
            NEUTRAL -> "😐"
            HAPPY -> "😊"
            EXCITED -> "😃"
        }
}