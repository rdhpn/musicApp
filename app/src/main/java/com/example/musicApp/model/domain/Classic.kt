package com.example.musicapp.model.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicApp.model.items.Result

@Entity
data class Classic(
    @PrimaryKey
    val trackId: Int,
    val artistId: Int,
    val artistName: String,
    val artistViewUrl: String,
    val artworkUrl60: String,
    val collectionName: String,
    val collectionPrice: Double,
    val trackPrice: Double
//    val resultcount: Int
)

fun Result?.mapToClassic(): Classic =
    Classic(
        trackId = this?.artistId ?: 0,
        artistId = this?.artistId ?: 0,
        artistName = this?.artistName ?: " - ",
        artistViewUrl = this?.artistViewUrl ?: " - ",
        artworkUrl60 = this?.artworkUrl30 ?: " - ",
        collectionName = this?.collectionName ?: " - ",
        collectionPrice = this?.collectionPrice ?: 0.0,
        trackPrice = this?.trackPrice ?: 0.0
//        resultcount = this?.resultcount ?: 0
    )
//package com.example.musicApp.model.domain
//
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//import com.example.musicApp.model.items.Result
//
//@Entity
//data class Classic(
//    @PrimaryKey
//    val id: String,
//    val name: String,
//    val climate: String,
//    val gravity: String,
//    val diameter: String,
//    val population: String,
//    val surfaceWater: String,
//    val terrain: String,
//    val description: String
//    )
//
//fun Result?.mapToClassic(): Classic =
//    Classic(
//        id = this?.id ?: " - ",
//        name = this?.properties?.name ?: " - ",
//        climate = this?.properties?.climate ?: " - ",
//        gravity = this?.properties?.gravity ?: " - ",
//        diameter = this?.properties?.diameter ?: " - ",
//        population = this?.properties?.population ?: " - ",
//        surfaceWater = this?.properties?.surfaceWater ?: " - ",
//        terrain = this?.properties?.terrain ?: " - ",
//        description = this?.description ?: "No description"
//    )