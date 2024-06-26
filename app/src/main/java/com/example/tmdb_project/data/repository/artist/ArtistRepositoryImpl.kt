package com.example.tmdb_project.data.repository.artist

import android.util.Log
import com.example.tmdb_project.data.model.artist.Artist
import com.example.tmdb_project.data.model.movie.Movie
import com.example.tmdb_project.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdb_project.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdb_project.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.tmdb_project.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdb_project.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdb_project.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdb_project.domain.repository.ArtistRepository
import com.example.tmdb_project.domain.repository.MovieRepository
import java.lang.Exception

class ArtistRepositoryImpl(

    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource

): ArtistRepository {



    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfNewArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfNewArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfNewArtists)
        return newListOfNewArtists
    }

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList:List<Artist>

        try {

            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body!=null){
                artistList = body.artists
            }

        }catch (exception:Exception){

            Log.i("MYTAG",exception.message.toString())

        }

        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList:List<Artist>

        try {

            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (exception:Exception){

            Log.i("MYTAG",exception.message.toString())

        }
        if (artistList.size>0){
            return artistList
        }
        else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{

        lateinit var artistList:List<Artist>

        try {

            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (exception:Exception){

            Log.i("MYTAG",exception.message.toString())

        }
        if (artistList.size>0){
            return artistList
        }
        else{
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList

    }
}