package com.example.tmdb_project.data.repository.tvshow.datasource

import com.example.tmdb_project.data.model.movie.MovieList
import com.example.tmdb_project.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {

    suspend fun getTvShows(): Response<TvShowList>

}