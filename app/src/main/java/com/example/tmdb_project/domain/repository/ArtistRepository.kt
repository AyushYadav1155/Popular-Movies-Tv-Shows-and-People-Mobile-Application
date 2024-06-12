package com.example.tmdb_project.domain.repository

import com.example.tmdb_project.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?

}