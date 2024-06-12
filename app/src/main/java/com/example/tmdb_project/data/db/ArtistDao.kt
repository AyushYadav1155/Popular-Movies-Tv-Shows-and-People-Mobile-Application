package com.example.tmdb_project.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_project.data.model.artist.Artist
import com.example.tmdb_project.data.model.tvshow.TvShow

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("Delete from popular_artists")
    suspend fun deleteAllArtists()

    @Query("Select * from popular_artists")
    suspend fun getArtists(): List<Artist>

}