package com.example.tmdb_project.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_project.data.model.movie.Movie
import com.example.tmdb_project.data.model.tvshow.TvShow
import com.example.tmdb_project.databinding.ActivityMovieBinding
import com.example.tmdb_project.databinding.ListItemBinding

class TvAdapter():RecyclerView.Adapter<MyViewHolder>() {

    private val tvList = ArrayList<TvShow>()

    fun setList(tvShows:List<TvShow>){
        tvList.clear()
        tvList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = ListItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvList[position])
    }
}


class MyViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){


    fun bind(tvShow:TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)


    }



}