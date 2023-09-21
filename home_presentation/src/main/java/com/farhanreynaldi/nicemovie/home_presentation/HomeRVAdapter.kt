package com.farhanreynaldi.nicemovie.home_presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farhanreynaldi.nicemovie.common.model.MovieList
import com.farhanreynaldi.nicemovie.home_presentation.databinding.HomeItemMovieBinding

class HomeRVAdapter(private val onClick: (String) -> Unit) : ListAdapter<MovieList, HomeRVAdapter.ItemViewholder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder =
        ItemViewholder(
            HomeItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: HomeRVAdapter.ItemViewholder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewholder(private val binding: HomeItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieList) = with(binding) {
            itemTvTitle.text = item.title
            itemTvYear.text = item.year
            Glide.with(itemView.context)
                .load(item.poster)
                .into(itemImg)

            root.setOnClickListener {
                item.imdbID?.let { it1 -> onClick.invoke(it1) }
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<MovieList>() {
    override fun areItemsTheSame(oldItem: MovieList, newItem: MovieList): Boolean {
        return oldItem.imdbID == newItem.imdbID
    }

    override fun areContentsTheSame(oldItem: MovieList, newItem: MovieList): Boolean {
        return oldItem == newItem
    }
}