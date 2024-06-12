package com.example.tmdb_project.data.repository.artist.datasourceImpl

import com.example.tmdb_project.data.api.TMDBService
import com.example.tmdb_project.data.model.artist.ArtistList
import com.example.tmdb_project.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}