package com.example.tmdb_project.presentation.di.core

import com.example.tmdb_project.data.api.TMDBService
import com.example.tmdb_project.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.tmdb_project.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdb_project.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmdb_project.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdb_project.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmdb_project.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDatasource{

        return MovieRemoteDataSourceImpl(tmdbService, apiKey)

    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDatasource{

        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)

    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {

        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)

    }

}