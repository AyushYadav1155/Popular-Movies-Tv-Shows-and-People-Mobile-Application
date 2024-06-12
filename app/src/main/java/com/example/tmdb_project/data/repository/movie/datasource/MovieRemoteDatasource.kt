package com.example.tmdb_project.data.repository.movie.datasource

import com.example.tmdb_project.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {

    suspend fun getMovies(): Response<MovieList>

}