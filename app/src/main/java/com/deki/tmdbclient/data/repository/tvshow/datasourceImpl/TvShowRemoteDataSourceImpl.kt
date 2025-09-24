package com.deki.tmdbclient.data.repository.tvshow.datasourceImpl

import com.deki.tmdbclient.data.api.TMDBService
import com.deki.tmdbclient.data.model.artist.ArtistList
import com.deki.tmdbclient.data.model.tvshow.TVShowList
import com.deki.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.deki.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TVShowList> =
        tmdbService.getPopularTvShows(apiKey)
}