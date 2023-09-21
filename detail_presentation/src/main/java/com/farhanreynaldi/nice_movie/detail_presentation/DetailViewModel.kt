package com.farhanreynaldi.nice_movie.detail_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.farhanreynaldi.nicemovie.detail_data.source.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getMovies(id: String) = repository.getMovies(id).asLiveData()
}