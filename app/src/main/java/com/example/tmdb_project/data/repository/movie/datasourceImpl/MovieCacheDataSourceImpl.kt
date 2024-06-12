package com.example.tmdb_project.data.repository.movie.datasourceImpl

import com.example.tmdb_project.data.model.movie.Movie
import com.example.tmdb_project.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {

        return movieList

    }

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}