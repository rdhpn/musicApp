package com.example.musicApp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.musicApp.model.domain.Classic
import com.example.musicApp.model.domain.Pop
import com.example.musicApp.model.domain.Rock

@Database(
    entities = [
        Rock::class,
        Classic::class,
        Pop::class
    ],
    version = 2
)
abstract class MusicDatabase : RoomDatabase() {
    abstract fun getMusicDAO(): MusicDAO
}