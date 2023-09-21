package com.farhanreynaldi.nicemovie.detail_data.source.network.api

import com.farhanreynaldi.nicemovie.detail_data.source.network.response.MovieDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun getDetailMovie(
        @Query("i") id: String,
        @Query("apikey") apiKey: String = "448903d7",
    ): MovieDetailResponse
}