package com.example.musicApp.di

import android.content.Context
import androidx.room.Room
import com.example.musicApp.database.MusicDAO
import com.example.musicApp.database.MusicDatabase
import com.example.musicApp.database.migration_1_2
import com.example.musicApp.rest.MusicRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun providesMusicDatabase(
        @ApplicationContext context: Context
    ): MusicDatabase =
        Room.databaseBuilder(
            context,
            MusicDatabase::class.java,
            "music-db"
        ).addMigrations(migration_1_2)
            .build()

    @Provides
    fun providesMusicDAO(
        musicDatabase: MusicDatabase
    ): MusicDAO =
        musicDatabase.getMusicDAO()
}