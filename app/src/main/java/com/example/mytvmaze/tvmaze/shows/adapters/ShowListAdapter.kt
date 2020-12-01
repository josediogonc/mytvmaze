package com.example.mytvmaze.tvmaze.shows.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytvmaze.databinding.LayoutShowListItemBinding
import com.example.mytvmaze.tvmaze.shows.viewHolder.ShowListViewHolder
import com.example.mytvmaze.tvmaze.shows.model.Show


class ShowListAdapter(
    private val showList: List<Show>
) : RecyclerView.Adapter<ShowListViewHolder>() {

    override fun getItemCount(): Int = showList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ShowListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutShowListItemBinding.inflate(inflater)
        return ShowListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShowListViewHolder, position: Int)
            = holder.bind(showList[position])
}