package com.farhanreynaldi.nicemovie.detail_data.source.network.response

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(

	@field:SerializedName("Released")
	val released: String? = null,

	@field:SerializedName("Plot")
	val plot: String? = null,

	@field:SerializedName("Director")
	val director: String? = null,

	@field:SerializedName("Title")
	val title: String? = null,

	@field:SerializedName("Actors")
	val actors: String? = null,

	@field:SerializedName("Runtime")
	val runtime: String? = null,

	@field:SerializedName("Awards")
	val awards: String? = null,

	@field:SerializedName("Year")
	val year: String? = null,

	@field:SerializedName("Language")
	val language: String? = null,

	@field:SerializedName("Rated")
	val rated: String? = null,

	@field:SerializedName("Poster")
	val poster: String? = null,

	@field:SerializedName("Country")
	val country: String? = null,

	@field:SerializedName("Genre")
	val genre: String? = null,

	@field:SerializedName("Writer")
	val writer: String? = null,

	@field:SerializedName("imdbRating")
	val imdbRating: String? = null
)
