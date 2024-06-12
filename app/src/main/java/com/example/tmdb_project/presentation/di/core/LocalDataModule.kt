package com.example.tmdb_project.presentation.di.core

import com.example.tmdb_project.data.db.ArtistDao
import com.example.tmdb_project.data.db.MovieDao
import com.example.tmdb_project.data.db.TvShowDao
import com.example.tmdb_project.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdb_project.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.tmdb_project.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdb_project.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.tmdb_project.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdb_project.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}