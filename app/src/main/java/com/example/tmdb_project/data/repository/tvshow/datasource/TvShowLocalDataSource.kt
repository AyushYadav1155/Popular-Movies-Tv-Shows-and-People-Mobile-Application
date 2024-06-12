package com.example.tmdb_project.data.repository.tvshow.datasource

import com.example.tmdb_project.data.model.movie.Movie
import com.example.tmdb_project.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
    suspend fun clearAll()
}