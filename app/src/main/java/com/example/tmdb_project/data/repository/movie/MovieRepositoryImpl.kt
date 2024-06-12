package com.example.tmdb_project.data.repository.movie

import android.util.Log
import com.example.tmdb_project.data.model.movie.Movie
import com.example.tmdb_project.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdb_project.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdb_project.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdb_project.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(

    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource

): MovieRepository {



    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfNewMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB(newListOfNewMovies)
        movieCacheDataSource.saveMovieToCache(newListOfNewMovies)
        return newListOfNewMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList:List<Movie>

        try {

            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body!=null){
                movieList = body.movies
            }

        }catch (exception:Exception){

            Log.i("MYTAG",exception.message.toString())

        }

        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList:List<Movie>

        try {

            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception:Exception){

            Log.i("MYTAG",exception.message.toString())

        }
        if (movieList.size>0){
            return movieList
        }
        else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovieToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{

        lateinit var movieList:List<Movie>

        try {

            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception:Exception){

            Log.i("MYTAG",exception.message.toString())

        }
        if (movieList.size>0){
            return movieList
        }
        else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(movieList)
        }

        return movieList

    }
}