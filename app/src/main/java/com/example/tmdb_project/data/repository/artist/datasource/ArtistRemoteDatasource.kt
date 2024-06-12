package com.example.tmdb_project.data.repository.artist.datasource

import com.example.tmdb_project.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {

    suspend fun getArtists(): Response<ArtistList>

}