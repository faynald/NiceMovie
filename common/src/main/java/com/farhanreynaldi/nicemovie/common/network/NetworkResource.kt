package com.farhanreynaldi.nicemovie.common.network

import com.farhanreynaldi.nicemovie.common.model.ApiResponse
import com.farhanreynaldi.nicemovie.common.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkResource<ResultType, RequestType> {
    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {
                emitAll(mapCallResult(apiResponse.data).map { Resource.Success(it) })
            }
            is ApiResponse.Empty -> {
                emit(Resource.Empty())
            }
            is ApiResponse.Error -> {
                emit(Resource.Error(apiResponse.errorMessage))
            }
        }
    }

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun mapCallResult(data: RequestType): Flow<ResultType>

    fun asFlow(): Flow<Resource<ResultType>> = result
}