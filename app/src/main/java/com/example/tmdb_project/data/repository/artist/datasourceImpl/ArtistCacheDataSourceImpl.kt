package com.example.tmdb_project.data.repository.artist.datasourceImpl

import com.example.tmdb_project.data.model.artist.Artist
import com.example.tmdb_project.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {

        return artistList

    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}