package com.example.tmdb_project.data.repository.tvshow.datasourceImpl

import com.example.tmdb_project.data.api.TMDBService
import com.example.tmdb_project.data.model.movie.MovieList
import com.example.tmdb_project.data.model.tvshow.TvShowList
import com.example.tmdb_project.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdb_project.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}