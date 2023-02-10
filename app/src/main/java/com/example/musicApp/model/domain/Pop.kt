package com.example.musicapp.model.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicApp.model.items.Result

@Entity
data class Pop(
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

fun Result?.mapToPop(): Pop =
    Pop(
        trackId = this?.artistId ?: 0,
        artistId = this?.artistId ?: 0,
        artistName = this?.artistName ?: " - ",
        artistViewUrl = this?.artistViewUrl ?: " - ",
        artworkUrl60 = this?.artworkUrl30 ?: " - ",
        collectionName = this?.collectionName ?: " - ",
        collectionPrice = this?.collectionPrice?: 0.0,
        trackPrice = this?.trackPrice?: 0.0
//        resultcount = this?.resultcount ?: 0
    )
//package com.example.musicApp.model.domain
//
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//import com.example.musicApp.model.items.Result
//
//@Entity("someName")
//data class Pop(
//    @PrimaryKey
//    val id: String,
//    val name: String,
//    val manufacturer: String,
//    val model: String,
//    val popClass: String,
//    val maxAtmospheringSpeed: String,
//    val costInCredits: String,
//    val cargoCapacity: String,
//    val description: String
//    )
//
//fun Result?.mapToPop(): Pop =
//    Pop(
//        id = this?.id ?: " - ",
//        name = this?.properties?.name ?: " - ",
//        manufacturer = this?.properties?.manufacturer ?: " - ",
//        model = this?.properties?.model ?: " - ",
//        popClass = this?.properties?.popClass ?: " - ",
//        maxAtmospheringSpeed = this?.properties?.maxAtmospheringSpeed ?: " - ",
//        costInCredits = this?.properties?.costInCredits ?: " - ",
//        cargoCapacity = this?.properties?.cargoCapacity ?: " - ",
//        description = this?.description ?: "No description"
//    )
