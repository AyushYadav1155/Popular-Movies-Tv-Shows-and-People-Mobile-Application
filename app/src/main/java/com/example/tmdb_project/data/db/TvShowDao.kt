package com.example.tmdb_project.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_project.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("Delete from popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query("Select * from popular_tvShows")
    suspend fun getTvShows(): List<TvShow>

}