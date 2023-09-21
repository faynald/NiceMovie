package com.farhanreynaldi.nicemovie.detail_data.source.network

import android.util.Log
import com.farhanreynaldi.nicemovie.common.model.ApiResponse
import com.farhanreynaldi.nicemovie.detail_data.source.network.api.ApiService
import com.farhanreynaldi.nicemovie.detail_data.source.network.response.MovieDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getDetailMovie(id: String): Flow<ApiResponse<List<MovieDetailResponse>>> {
        return flow {
            try {
                val response = apiService.getDetailMovie(id)
                if (response != null) {
                    emit(ApiResponse.Success(listOf(response)))
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