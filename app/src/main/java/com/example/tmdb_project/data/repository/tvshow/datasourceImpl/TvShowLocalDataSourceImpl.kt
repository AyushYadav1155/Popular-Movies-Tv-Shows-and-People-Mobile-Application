package com.example.tmdb_project.data.repository.tvshow.datasourceImpl

import com.example.tmdb_project.data.db.MovieDao
import com.example.tmdb_project.data.db.TvShowDao
import com.example.tmdb_project.data.model.movie.Movie
import com.example.tmdb_project.data.model.tvshow.TvShow
import com.example.tmdb_project.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdb_project.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {

            tvShowDao.saveTvShows(tvShows)

        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()

        }
    }
}