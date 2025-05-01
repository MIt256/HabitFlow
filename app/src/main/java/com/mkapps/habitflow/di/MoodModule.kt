package com.mkapps.habitflow.di

import com.mkapps.habitflow.data.db.MoodEntryDao
import com.mkapps.habitflow.data.mood.MoodRepositoryImpl
import com.mkapps.habitflow.domain.mood.MoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMoodRepository(dao: MoodEntryDao): MoodRepository {
        return MoodRepositoryImpl(dao)
    }
}