package com.example.musicApp.model.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicApp.model.items.Result

@Entity
data class Rock(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val trackId: Int,
    val artistId: Int,
    val artistName: String,
    val artistViewUrl: String,
    val artworkUrl60: String,
    val previewUrl: String,
    val collectionName: String,
    val collectionPrice: Double,
    val trackPrice: Double
//    val resultcount: Int
    )

fun Result?.mapToRock(): Rock =
    Rock(
        trackId = this?.trackId?: 0,
        artistId = this?.artistId ?: 0,
        artistName = this?.artistName ?: " - ",
        artistViewUrl = this?.artistViewUrl ?: " - ",
        previewUrl = this?.previewUrl ?: " - ",
        artworkUrl60 = this?.artworkUrl30 ?: " - ",
        collectionName = this?.collectionName ?: " - ",
        collectionPrice = this?.collectionPrice?: 0.0,
        trackPrice = this?.trackPrice?: 0.0
//        resultcount = this?.resultcount ?: 0
    )
