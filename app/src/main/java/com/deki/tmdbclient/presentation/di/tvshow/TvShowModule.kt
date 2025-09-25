package com.deki.tmdbclient.presentation.di.tvshow

import com.deki.tmdbclient.domain.usecases.GetArtistsUseCase
import com.deki.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.deki.tmdbclient.domain.usecases.UpdateArtistsUseCase
import com.deki.tmdbclient.domain.usecases.UpdateTvShowsUseCase
import com.deki.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.deki.tmdbclient.presentation.di.artist.ArtistScope
import com.deki.tmdbclient.presentation.di.movie.MovieScope
import com.deki.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}