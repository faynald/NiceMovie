package com.farhanreynaldi.nivemovie.home_data.source.network

import android.util.Log
import com.farhanreynaldi.nicemovie.common.model.ApiResponse
import com.farhanreynaldi.nivemovie.home_data.source.network.api.ApiService
import com.farhanreynaldi.nivemovie.home_data.source.network.response.MovieListResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getMovies(): Flow<ApiResponse<List<MovieListResponseItem>>> {
        return flow {
            try {
                val response = apiService.getMovie()
                val data = response.data
                if (data != null) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource getBatik", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}