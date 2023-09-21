package com.farhanreynaldi.nivemovie.home_data.source

import com.farhanreynaldi.nicemovie.common.model.ApiResponse
import com.farhanreynaldi.nicemovie.common.model.MovieList
import com.farhanreynaldi.nicemovie.common.model.Resource
import com.farhanreynaldi.nicemovie.common.network.NetworkResource
import com.farhanreynaldi.nivemovie.home_data.source.network.NetworkDataSource
import com.farhanreynaldi.nivemovie.home_data.source.network.response.MovieListResponseItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val networkDataSource: NetworkDataSource
) {
    fun getMovies(): Flow<Resource<List<MovieList>>> =
        object : NetworkResource<List<MovieList>, List<MovieListResponseItem>>() {
            override suspend fun createCall(): Flow<ApiResponse<List<MovieListResponseItem>>> =
                networkDataSource.getMovies()

            override suspend fun mapCallResult(data: List<MovieListResponseItem>): Flow<List<MovieList>> =
                flowOf(MovieMapper.mapResponsesToDomain(data))

        }.asFlow()
}