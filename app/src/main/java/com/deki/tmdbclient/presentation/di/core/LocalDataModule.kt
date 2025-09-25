package com.deki.tmdbclient.presentation.di.core

import com.deki.tmdbclient.data.db.ArtistDAO
import com.deki.tmdbclient.data.db.MovieDAO
import com.deki.tmdbclient.data.db.TvShowDAO
import com.deki.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.deki.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.deki.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.deki.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.deki.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.deki.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDAO)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDAO: TvShowDAO): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDAO)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDAO)
    }
}