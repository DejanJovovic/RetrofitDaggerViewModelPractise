package com.deki.tmdbclient.presentation.di

import com.deki.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.deki.tmdbclient.presentation.di.movie.MovieSubComponent
import com.deki.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}