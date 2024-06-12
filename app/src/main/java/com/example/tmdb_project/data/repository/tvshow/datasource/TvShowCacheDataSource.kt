package com.example.tmdb_project.data.repository.tvshow.datasource

import com.example.tmdb_project.data.model.movie.Movie
import com.example.tmdb_project.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}