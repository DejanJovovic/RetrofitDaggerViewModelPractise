package com.deki.tmdbclient.data.repository.artist.datasourceImpl

import com.deki.tmdbclient.data.api.TMDBService
import com.deki.tmdbclient.data.model.artist.ArtistList
import com.deki.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> =
        tmdbService.getPopularArtist(apiKey)
}