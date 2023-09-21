package com.farhanreynaldi.nicemovie.detail_data.source

import com.farhanreynaldi.nicemovie.common.model.ApiResponse
import com.farhanreynaldi.nicemovie.common.model.MovieDetail
import com.farhanreynaldi.nicemovie.common.model.MovieList
import com.farhanreynaldi.nicemovie.common.model.Resource
import com.farhanreynaldi.nicemovie.common.network.NetworkResource
import com.farhanreynaldi.nicemovie.detail_data.source.network.NetworkDataSource
import com.farhanreynaldi.nicemovie.detail_data.source.network.response.MovieDetailResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val networkDataSource: NetworkDataSource
) {
    fun getMovies(id: String): Flow<Resource<List<MovieDetail>>> =
        object : NetworkResource<List<MovieDetail>, List<MovieDetailResponse>>() {
            override suspend fun createCall(): Flow<ApiResponse<List<MovieDetailResponse>>> =
                networkDataSource.getDetailMovie(id)

            override suspend fun mapCallResult(data: List<MovieDetailResponse>): Flow<List<MovieDetail>> =
                flowOf(DetailMovieMapper.mapResponsesToDomain(data))

        }.asFlow()
}