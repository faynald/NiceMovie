package com.farhanreynaldi.nivemovie.home_data.source

import com.farhanreynaldi.nicemovie.common.model.MovieList
import com.farhanreynaldi.nivemovie.home_data.source.network.response.MovieListResponseItem

object MovieMapper {
    fun mapResponsesToDomain(input: List<MovieListResponseItem>): List<MovieList> {
        val dataList = ArrayList<MovieList>()
        input.map {
            val data = MovieList(
                type = it.type,
                year = it.year,
                imdbID = it.imdbID,
                poster = it.poster,
                title = it.title
            )
            dataList.add(data)
        }
        return dataList
    }
}