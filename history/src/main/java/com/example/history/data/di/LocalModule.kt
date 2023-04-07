package com.example.history.data.di

import android.content.Context
import androidx.room.Room
import com.example.history.data.local.HistoryDao
import com.example.history.data.local.HistoryDatabase
import com.example.history.data.repo.HistoryRepositiryImpl
import com.example.history.data.repo.HistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalModule {

    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): HistoryDatabase {
        return Room.databaseBuilder(
            appContext,
            HistoryDatabase::class.java,
            "weather.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideHistoryDao(historyDatabase: HistoryDatabase): HistoryDao {
        return historyDatabase.historyDao()
    }

    @Provides
    fun provideHistoryRepository(historyDatabase: HistoryDatabase): HistoryRepository {
        return HistoryRepositiryImpl(historyDatabase)
    }
}