package com.example.mytvmaze.tvmaze.shows

import androidx.recyclerview.widget.RecyclerView
import com.example.mytvmaze.databinding.LayoutShowListItemBinding
import com.example.mytvmaze.tvmaze.shows.model.Show

class ShowListViewHolder(val binding: LayoutShowListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind(show : Show) {
            with(show) {
                initName()
                initGenres()
                initPoster()
            }
        }

    private fun Show.initName() {
        binding.tvTitle.text = this.name
    }

    private fun Show.initGenres() {
        binding.tvGenres.text = this.genres.joinToString(separator = " / ") { it }
    }

    private fun Show.initPoster() {
        //Picasso.get().load() TODO: terminar
    }
}
