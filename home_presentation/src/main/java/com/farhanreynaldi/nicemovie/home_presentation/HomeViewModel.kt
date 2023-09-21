package com.farhanreynaldi.nicemovie.home_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.farhanreynaldi.nivemovie.home_data.source.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getMovies() = repository.getMovies().asLiveData()
}