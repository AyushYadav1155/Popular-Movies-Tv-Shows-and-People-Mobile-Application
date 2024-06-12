package com.example.tmdb_project.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_project.data.model.artist.Artist
import com.example.tmdb_project.data.model.movie.Movie
import com.example.tmdb_project.databinding.ActivityMovieBinding
import com.example.tmdb_project.databinding.ListItemBinding

class ArtistAdapter():RecyclerView.Adapter<MyViewHolder>() {

    private val artistList = ArrayList<Artist>()

    fun setList(artists:List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
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
        return artistList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }
}


class MyViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){


    fun bind(artist:Artist){
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = "Popularity Score : "+artist.popularity.toString()
        val posterURL = "https://image.tmdb.org/t/p/w500"+artist.profilePath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)


    }



}