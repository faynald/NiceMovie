package com.farhanreynaldi.nice_movie.detail_presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.farhanreynaldi.nice_movie.detail_presentation.databinding.ActivityDetailBinding
import com.farhanreynaldi.nicemovie.common.model.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra(EXTRA_ID)
        if (id != null) {
            viewModel.getMovies(id).observe(this@DetailActivity) { movieData ->
                if (movieData != null) {
                    when (movieData) {
                        is Resource.Loading -> binding.homeLoading.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.homeLoading.visibility = View.GONE

                            val data = movieData.data?.first()
                            with(binding) {
                                Glide.with(this@DetailActivity)
                                    .load(data?.poster)
                                    .into(imgDetailImage)
                                tvDetailTitle.text = data?.title
                                detailTvDate.text = data?.released
                                detailTvDuration.text = data?.runtime
                                detailTvRating.text = data?.rated.toString()
                                detailTvDescription.text = data?.plot
                                detailTvGenre.text = data?.genre
                                detailTvDirector.text = data?.director
                                detailTvActors.text = data?.actors
                                detailTvWriter.text = data?.writer
                            }
                        }
                        is Resource.Empty -> {
                        }
                        is Resource.Error -> {
                            Log.e("viewModel.getBatik()", "ERROR ${movieData.message}")
                        }
                    }
                }
            }
        }

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }

    companion object {
        const val EXTRA_ID = "extra_id"
    }
}