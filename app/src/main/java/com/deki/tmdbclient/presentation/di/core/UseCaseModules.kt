package com.deki.tmdbclient.presentation.di.core

import com.deki.tmdbclient.domain.repository.ArtistRepository
import com.deki.tmdbclient.domain.repository.MovieRepository
import com.deki.tmdbclient.domain.repository.TvShowsRepository
import com.deki.tmdbclient.domain.usecases.GetArtistsUseCase
import com.deki.tmdbclient.domain.usecases.GetMoviesUseCase
import com.deki.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.deki.tmdbclient.domain.usecases.UpdateArtistsUseCase
import com.deki.tmdbclient.domain.usecases.UpdateMoviesUseCase
import com.deki.tmdbclient.domain.usecases.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModules {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowsRepository: TvShowsRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }
}