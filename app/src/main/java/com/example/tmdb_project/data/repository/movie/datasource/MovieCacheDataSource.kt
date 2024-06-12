package com.example.tmdb_project.data.repository.movie.datasource

import com.example.tmdb_project.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMovieToCache(movies:List<Movie>)
}