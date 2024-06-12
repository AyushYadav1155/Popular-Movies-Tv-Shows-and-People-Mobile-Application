package com.example.tmdb_project.presentation.di.tvshow

import com.example.tmdb_project.presentation.artist.ArtistActivity
import com.example.tmdb_project.presentation.tv.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }

}