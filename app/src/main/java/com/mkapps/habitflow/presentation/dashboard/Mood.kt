package com.mkapps.habitflow.presentation.dashboard

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