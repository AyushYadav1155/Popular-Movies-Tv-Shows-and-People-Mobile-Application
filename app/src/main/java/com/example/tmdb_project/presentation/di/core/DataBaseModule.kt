package com.example.tmdb_project.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdb_project.data.db.ArtistDao
import com.example.tmdb_project.data.db.MovieDao
import com.example.tmdb_project.data.db.TMDBDatabase
import com.example.tmdb_project.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun providesMovieDataBase(context: Context):TMDBDatabase{

        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient").build()

    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return  tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase):TvShowDao{
        return  tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao{
        return  tmdbDatabase.artistDao()
    }

}