package com.example.tmdb_project.data.repository.tvshow

import android.util.Log
import com.example.tmdb_project.data.model.movie.Movie
import com.example.tmdb_project.data.model.tvshow.TvShow
import com.example.tmdb_project.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdb_project.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdb_project.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdb_project.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdb_project.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdb_project.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdb_project.domain.repository.MovieRepository
import com.example.tmdb_project.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(

    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource

): TvShowRepository {



    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfNewTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfNewTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfNewTvShows)
        return newListOfNewTvShows
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowsList:List<TvShow>

        try {

            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body!=null){
                tvShowsList = body.tvShows
            }

        }catch (exception:Exception){

            Log.i("MYTAG",exception.message.toString())

        }

        return tvShowsList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowsList:List<TvShow>

        try {

            tvShowsList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (exception:Exception){

            Log.i("MYTAG",exception.message.toString())

        }
        if (tvShowsList.size>0){
            return tvShowsList
        }
        else{
            tvShowsList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowsList)
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{

        lateinit var tvShowsList:List<TvShow>

        try {

            tvShowsList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (exception:Exception){

            Log.i("MYTAG",exception.message.toString())

        }
        if (tvShowsList.size>0){
            return tvShowsList
        }
        else{
            tvShowsList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        }

        return tvShowsList

    }
}