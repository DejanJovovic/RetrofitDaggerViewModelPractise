package com.deki.tmdbclient.data.repository.tvshow.datasource

import com.deki.tmdbclient.data.model.tvshow.TVShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TVShow>
    suspend fun saveTvShowsToCache(tvShows: List<TVShow>)
}