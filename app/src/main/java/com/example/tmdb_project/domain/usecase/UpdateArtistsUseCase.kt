package com.example.tmdb_project.domain.usecase

import com.example.tmdb_project.data.model.artist.Artist
import com.example.tmdb_project.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? = artistRepository.updateArtists()

}