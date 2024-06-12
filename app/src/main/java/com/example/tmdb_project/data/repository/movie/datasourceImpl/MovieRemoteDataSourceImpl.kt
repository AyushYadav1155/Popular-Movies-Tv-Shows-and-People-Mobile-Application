package com.example.tmdb_project.data.repository.movie.datasourceImpl

import com.example.tmdb_project.data.api.TMDBService
import com.example.tmdb_project.data.model.movie.MovieList
import com.example.tmdb_project.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}