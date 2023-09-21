package com.farhanreynaldi.nivemovie.home_data.di

import com.farhanreynaldi.nivemovie.home_data.source.Repository
import com.farhanreynaldi.nivemovie.home_data.source.network.NetworkDataSource
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