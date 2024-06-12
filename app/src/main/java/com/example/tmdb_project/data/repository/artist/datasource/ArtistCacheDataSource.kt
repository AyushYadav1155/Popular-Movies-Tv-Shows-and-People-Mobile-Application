package com.example.tmdb_project.data.repository.artist.datasource

import com.example.tmdb_project.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}