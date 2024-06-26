package com.example.tmdb_project.presentation.di.movie

import com.example.tmdb_project.domain.usecase.GetArtistsUseCase
import com.example.tmdb_project.domain.usecase.GetMoviesUseCase
import com.example.tmdb_project.domain.usecase.UpdateArtistsUseCase
import com.example.tmdb_project.domain.usecase.UpdateMoviesUseCase
import com.example.tmdb_project.presentation.artist.ArtistViewModelFactory
import com.example.tmdb_project.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase,
                                      updateMoviesUseCase: UpdateMoviesUseCase):MovieViewModelFactory{

        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)

    }

}