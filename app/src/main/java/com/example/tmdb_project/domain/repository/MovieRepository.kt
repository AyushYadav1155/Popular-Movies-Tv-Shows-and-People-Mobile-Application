package com.example.tmdb_project.domain.repository

import com.example.tmdb_project.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}