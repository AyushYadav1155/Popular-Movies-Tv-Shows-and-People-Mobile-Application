package com.example.tmdb_project.domain.usecase

import com.example.tmdb_project.data.model.tvshow.TvShow
import com.example.tmdb_project.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()

}