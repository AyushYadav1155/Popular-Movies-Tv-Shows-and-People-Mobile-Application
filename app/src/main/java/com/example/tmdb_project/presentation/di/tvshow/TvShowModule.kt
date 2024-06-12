package com.example.tmdb_project.presentation.di.tvshow

import com.example.tmdb_project.domain.usecase.GetArtistsUseCase
import com.example.tmdb_project.domain.usecase.GetTvShowsUseCase
import com.example.tmdb_project.domain.usecase.UpdateArtistsUseCase
import com.example.tmdb_project.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdb_project.presentation.artist.ArtistViewModelFactory
import com.example.tmdb_project.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowsUseCase: GetTvShowsUseCase,
                                      updateTvShowsUseCase: UpdateTvShowsUseCase):TvShowViewModelFactory{

        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)

    }

}