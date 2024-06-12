package com.example.tmdb_project.presentation.di.core


import com.example.tmdb_project.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdb_project.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.tmdb_project.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdb_project.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.tmdb_project.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdb_project.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}