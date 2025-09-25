package com.deki.tmdbclient.presentation.di.tvshow

import com.deki.tmdbclient.presentation.artist.ArtistActivity
import com.deki.tmdbclient.presentation.di.artist.ArtistModule
import com.deki.tmdbclient.presentation.di.artist.ArtistScope
import com.deki.tmdbclient.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

}