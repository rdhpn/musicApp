package com.example.musicApp.model.items


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MusicResponse(
    @Json(name = "resultCount")
    val resultCount: Int? = null,
    @Json(name = "results")
    val results: List<Result?>? = null
)
//@JsonClass(generateAdapter = true)
//data class DetailsResponse(
//    @Json(name = "message")
//    val message: String? = null,
//    @Json(name = "result")
//    val result: Result? = null
//)