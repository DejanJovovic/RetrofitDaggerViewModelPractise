package com.deki.tmdbclient.presentation

import android.app.Application
import com.deki.tmdbclient.BuildConfig
import com.deki.tmdbclient.presentation.di.Injector
import com.deki.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.deki.tmdbclient.presentation.di.core.AppComponent
import com.deki.tmdbclient.presentation.di.core.AppModule
import com.deki.tmdbclient.presentation.di.core.DaggerAppComponent
import com.deki.tmdbclient.presentation.di.core.NetModule
import com.deki.tmdbclient.presentation.di.core.RemoteDataModule
import com.deki.tmdbclient.presentation.di.movie.MovieSubComponent
import com.deki.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}