package com.example.musicApp.model


import com.example.musicApp.model.items.Result
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MusicResponse(
    @Json(name = "resultCount")
    val resultCount: Int? = null,
    @Json(name = "results")
    val results: List<Result>? = null
)
