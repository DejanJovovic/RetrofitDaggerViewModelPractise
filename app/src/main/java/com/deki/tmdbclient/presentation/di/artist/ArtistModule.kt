package com.deki.tmdbclient.presentation.di.artist

import com.deki.tmdbclient.domain.usecases.GetArtistsUseCase
import com.deki.tmdbclient.domain.usecases.UpdateArtistsUseCase
import com.deki.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}