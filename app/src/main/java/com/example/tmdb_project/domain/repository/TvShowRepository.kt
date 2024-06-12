package com.example.tmdb_project.domain.repository

import com.example.tmdb_project.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?

}