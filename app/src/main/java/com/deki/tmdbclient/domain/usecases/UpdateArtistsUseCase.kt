package com.deki.tmdbclient.domain.usecases

import com.deki.tmdbclient.data.model.artist.Artist
import com.deki.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}