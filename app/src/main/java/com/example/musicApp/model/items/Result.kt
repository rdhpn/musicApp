

package com.example.musicApp.model.items


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "trackId")
    val trackId: Int? = null,
    @Json(name = "artistId")
    val artistId: Int? = null,
    @Json(name = "artistName")
    val artistName: String? = null,
    @Json(name = "artistViewUrl")
    val artistViewUrl: String? = null,
    @Json(name = "artworkUrl100")
    val artworkUrl100: String? = null,
    @Json(name = "artworkUrl30")
    val artworkUrl30: String? = null,
    @Json(name = "artworkUrl60")
    val artworkUrl60: String? = null,
    @Json(name = "collectionId")
    val collectionId: Int? = null,
    @Json(name = "collectionName")
    val collectionName: String? = null,
    @Json(name = "collectionPrice")
    val collectionPrice: Double? = null,
    @Json(name = "collectionViewUrl")
    val collectionViewUrl: String? = null,
    @Json(name = "contentAdvisoryRating")
    val contentAdvisoryRating: String? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "currency")
    val currency: String? = null,
    @Json(name = "discCount")
    val previewUrl: String? = null,
    @Json(name = "primaryGenreName")
    val primaryGenreName: String? = null,
    @Json(name = "releaseDate")
    val releaseDate: String? = null,
    @Json(name = "trackPrice")
    val trackPrice: Double? = null,
    @Json(name = "categoryOfMusic")
    val categoryOfMusic: String?
)
