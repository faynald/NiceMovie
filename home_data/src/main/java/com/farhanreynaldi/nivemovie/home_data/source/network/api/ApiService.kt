package com.farhanreynaldi.nivemovie.home_data.source.network.api

import com.farhanreynaldi.nivemovie.home_data.source.network.response.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService { // s=batman&type=movie&apikey=448903d7&page=2

    @GET("/")
    suspend fun getMovie(
        @Query("s") keyword: String = "batman",
        @Query("apikey") apiKey: String = "448903d7",
        @Query("page") page: Int = 1
    ): MovieListResponse


//    fun getProfileData(@Query("id") id: Int): // TODO

}