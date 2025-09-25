package com.deki.tmdbclient.presentation.di.core

import com.deki.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.deki.tmdbclient.presentation.di.core.AppModule
import com.deki.tmdbclient.presentation.di.core.CacheDataModule
import com.deki.tmdbclient.presentation.di.core.DatabaseModule
import com.deki.tmdbclient.presentation.di.core.LocalDataModule
import com.deki.tmdbclient.presentation.di.core.NetModule
import com.deki.tmdbclient.presentation.di.core.RemoteDataModule
import com.deki.tmdbclient.presentation.di.core.RepositoryModule
import com.deki.tmdbclient.presentation.di.core.UseCaseModules
import com.deki.tmdbclient.presentation.di.movie.MovieSubComponent
import com.deki.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModules::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory

}