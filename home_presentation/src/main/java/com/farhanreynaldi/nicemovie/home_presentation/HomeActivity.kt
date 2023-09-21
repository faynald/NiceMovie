package com.farhanreynaldi.nicemovie.home_presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.farhanreynaldi.nice_movie.detail_presentation.DetailActivity
import com.farhanreynaldi.nicemovie.common.model.Resource
import com.farhanreynaldi.nicemovie.home_presentation.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupOnClick()



        val movieAdapter = HomeRVAdapter(::onMovieClicked)
        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        viewModel.getMovies().observe(this@HomeActivity) { movies ->
            if (movies != null) {
                when (movies) {
                    is Resource.Loading -> binding.homeLoading.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.homeLoading.visibility = View.GONE
                        movies.data?.let {
                            movieAdapter.submitList(it)
                        }
                    }
                    is Resource.Empty -> {
                    }
                    is Resource.Error -> {
                        Log.e("viewModel.getBatik()", "ERROR ${movies.message}")
                    }
                }
            }
        }

    }

    private fun onMovieClicked(id: String) {
        val intent = Intent(
            this@HomeActivity,
            DetailActivity::class.java
        )
        intent.putExtra(DetailActivity.EXTRA_ID, id)
        startActivity(intent)
    }

    private fun setupOnClick() {
        with(binding) {
            homeBtnSearch.setOnClickListener {  }
            homeBtnFilter.setOnClickListener {  }
            homeBtnFavorite.setOnClickListener {  }
        }
    }
}