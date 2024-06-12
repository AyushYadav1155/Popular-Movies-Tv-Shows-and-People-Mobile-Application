package com.example.tmdb_project.presentation.di.artist

import com.example.tmdb_project.domain.usecase.GetArtistsUseCase
import com.example.tmdb_project.domain.usecase.UpdateArtistsUseCase
import com.example.tmdb_project.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(getArtistsUseCase: GetArtistsUseCase,
                                      updateArtistsUseCase: UpdateArtistsUseCase):ArtistViewModelFactory{

        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)

    }

}