package com.example.tmdb_project.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_project.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("Delete from popular_movies")
    suspend fun deleteAllMovies()

    @Query("Select * from popular_movies")
    suspend fun getMovies(): List<Movie>

}