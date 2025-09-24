package com.deki.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.deki.tmdbclient.domain.usecases.GetArtistsUseCase
import com.deki.tmdbclient.domain.usecases.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val artistsList = getArtistsUseCase.execute()
        emit(artistsList)
    }

    fun updateTvShows() = liveData {
        val artistsList = updateArtistsUseCase.execute()
        emit(artistsList)
    }
}