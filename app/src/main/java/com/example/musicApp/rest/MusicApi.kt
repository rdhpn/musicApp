package com.example.musicApp.rest

import com.example.musicApp.model.MusicResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicApi {

    @GET(SEARCH)
    suspend fun getListBy(
    @Query("term") term: String = "" ,
    @Query("amp;media", encoded = true) media: String = "",
    @Query("amp;entity", encoded = true) entity: String = "",
    @Query("amp;limit", encoded = true) limit: String = "",
    ): Response<MusicResponse>

    companion object {
        const val BASE_URL = "https://itunes.apple.com/"
        private const val SEARCH = "search"
    }
}