package com.example.musicApp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.musicapp.model.domain.Classic
import com.example.musicapp.model.domain.Pop
import com.example.musicapp.model.domain.Rock

@Dao
interface MusicDAO {

    @Query("SELECT * FROM rocks")
    suspend fun getRocks(): List<Rock>

    @Query("SELECT * FROM rocks WHERE character_name LIKE :characterName LIMIT 1")
    suspend fun getCharacterByName(characterName: String): Rock

    @Query("SELECT * FROM classic")
    suspend fun getClassics(): List<Classic>

    @Query("SELECT * FROM pop")
    suspend fun getPops(): List<Pop>

    @Insert(
        entity = Rock::class,
        onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRock(vararg rock: Rock)

    @Insert(
        entity = Classic::class,
        onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClassics(vararg rock: Classic)

    @Insert(
        entity = Pop::class,
        onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPops(vararg rock: Pop)
}