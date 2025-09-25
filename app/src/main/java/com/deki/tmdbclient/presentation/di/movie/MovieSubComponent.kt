package com.deki.tmdbclient.presentation.di.movie

import com.deki.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

//this injects dependencies to artist activity

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}