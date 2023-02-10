package com.example.musicapp.model.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicApp.model.items.Result

@Entity
data class Track(
    @PrimaryKey
    val trackId: Int,
    val artistId: Int,
    val categoryOfMusic: String,
    val artistName: String,
    val previewUrl: String,
    val artistViewUrl: String,
    val artworkUrl60: String,
    val collectionName: String,
    val collectionPrice: Double,
    val trackPrice: Double
//    val resultcount: Int
    )

fun Result?.mapToTrack(): Track =
    Track(
        trackId = this?.artistId ?: 0,
        artistId = this?.artistId ?: 0,
        artistName = this?.artistName ?: " - ",
        previewUrl = this?.previewUrl ?: " - ",
        artistViewUrl = this?.artistViewUrl ?: " - ",
        categoryOfMusic = this?.categoryOfMusic ?: " - ",
        artworkUrl60 = this?.artworkUrl30 ?: " - ",
        collectionName = this?.collectionName ?: " - ",
        collectionPrice = this?.collectionPrice?: 0.0,
        trackPrice = this?.trackPrice?: 0.0
//        resultcount = this?.resultcount ?: 0
    )
