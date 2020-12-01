package com.example.mytvmaze.tvmaze.shows

import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mytvmaze.R
import com.example.mytvmaze.core.image.ImageFactory
import com.example.mytvmaze.core.extensions.toHTML
import com.example.mytvmaze.databinding.LayoutShowListItemBinding
import com.example.mytvmaze.tvmaze.shows.model.Show
import com.example.mytvmaze.tvmaze.shows.ui.ShowsFragmentDirections

class ShowListViewHolder(
    private val binding: LayoutShowListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(show: Show) {
        with(show) {
            initName()
            initGenres()
            initPremiered()
            initPoster()
            initStatus()
            initType()
            initRating()
            initNetwork()
            initSchedule()
            setOnItemClickedListener()
        }
    }

    private fun Show.setOnItemClickedListener() {
        binding.root.setOnClickListener {
            val directions = ShowsFragmentDirections.actionShowsFragmentToShowDetailsFragment(this)
            findNavController(it).navigate(directions)
        }
    }

    private fun Show.initSchedule() =
        "<b>Schedule: </b> ${schedule}".toHTML().also { binding.tvSchedule.text = it }

    private fun Show.initRating() =
        rating.average?.let { averageRating ->
            binding.rating.text = averageRating.toString()
            binding.ratingBar.rating = averageRating / 2
        }

    private fun Show.initNetwork() =
        "<b>Network: </b> ${network?.name ?: "(unknown)" }".toHTML().also { binding.tvNetwork.text = it }

    private fun Show.initStatus() =
        "<b>Status: </b> $status".toHTML().also { binding.tvStatus.text = it }

    private fun Show.initPremiered() =
        "<b>Premiered: </b> ${premiered ?: "(unknown)" }".toHTML().also { binding.tvPremiered.text = it }

    private fun Show.initType() =
        "<b>Type: </b> $type".toHTML().also { binding.tvType.text = it }

    private fun Show.initGenres() =
        genresAsString.also { binding.tvGenres.text = it }

    private fun Show.initName() {
        binding.tvTitle.text = this.name
    }

    private fun Show.initPoster() =
        this.poster?.medium?.let {
            ImageFactory.load(it, R.drawable.placeholder_movie_poster, binding.bannerImg)
        }
}
