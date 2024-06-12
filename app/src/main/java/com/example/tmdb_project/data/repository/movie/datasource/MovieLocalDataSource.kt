package com.example.tmdb_project.data.repository.movie.datasource

import com.example.tmdb_project.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMovieToDB(movies:List<Movie>)
    suspend fun clearAll()
}