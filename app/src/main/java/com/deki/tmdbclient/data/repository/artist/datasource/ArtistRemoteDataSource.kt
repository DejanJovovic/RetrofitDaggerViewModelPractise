package com.deki.tmdbclient.data.repository.artist.datasource

import com.deki.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>

}