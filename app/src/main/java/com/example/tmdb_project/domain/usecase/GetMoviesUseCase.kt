package com.example.tmdb_project.domain.usecase

import com.example.tmdb_project.data.model.movie.Movie
import com.example.tmdb_project.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()

}