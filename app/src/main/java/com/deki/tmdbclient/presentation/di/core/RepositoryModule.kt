package com.deki.tmdbclient.presentation.di.core

import com.deki.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.deki.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.deki.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.deki.tmdbclient.data.repository.artist.datasourceImpl.ArtistRepositoryImpl
import com.deki.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.deki.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.deki.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.deki.tmdbclient.data.repository.movie.datasourceImpl.MovieRepositoryImpl
import com.deki.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.deki.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.deki.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.deki.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRepositoryImpl
import com.deki.tmdbclient.domain.repository.ArtistRepository
import com.deki.tmdbclient.domain.repository.MovieRepository
import com.deki.tmdbclient.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDataSource
        )

    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowsRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )

    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )

    }
}