package com.farhanreynaldi.nicemovie.detail_data.source

import com.farhanreynaldi.nicemovie.common.model.MovieDetail
import com.farhanreynaldi.nicemovie.detail_data.source.network.response.MovieDetailResponse


object DetailMovieMapper {
    fun mapResponsesToDomain(input: List<MovieDetailResponse>): List<MovieDetail> {
        val dataList = ArrayList<MovieDetail>()
        input.map {
            val data = MovieDetail(
                released = it.released,
                plot = it.plot,
                director = it.director,
                title = it.title,
                actors = it.actors,
                runtime = it.runtime,
                awards = it.awards,
                year = it.year,
                language = it.language,
                rated = it.rated,
                poster = it.poster,
                country = it.country,
                genre = it.genre,
                writer = it.writer
            )
            dataList.add(data)
        }
        return dataList
    }
}