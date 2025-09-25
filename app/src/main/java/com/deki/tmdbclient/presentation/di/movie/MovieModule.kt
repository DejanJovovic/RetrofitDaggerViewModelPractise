package com.deki.tmdbclient.presentation.di.movie

import com.deki.tmdbclient.domain.usecases.GetArtistsUseCase
import com.deki.tmdbclient.domain.usecases.GetMoviesUseCase
import com.deki.tmdbclient.domain.usecases.UpdateArtistsUseCase
import com.deki.tmdbclient.domain.usecases.UpdateMoviesUseCase
import com.deki.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.deki.tmdbclient.presentation.di.artist.ArtistScope
import com.deki.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}