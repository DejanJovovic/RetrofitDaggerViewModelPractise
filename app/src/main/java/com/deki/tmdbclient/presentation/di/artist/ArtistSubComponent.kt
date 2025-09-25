package com.deki.tmdbclient.presentation.di.artist

import com.deki.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

//this injects dependencies to artist activity

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }

}