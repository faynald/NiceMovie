package com.farhanreynaldi.nicemovie.detail_data.di

import com.farhanreynaldi.nicemovie.detail_data.source.Repository
import com.farhanreynaldi.nicemovie.detail_data.source.network.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        network: NetworkDataSource
    ): Repository =
        Repository(network)

}