package com.deki.tmdbclient.data.repository.tvshow.datasource

import com.deki.tmdbclient.data.model.artist.Artist
import com.deki.tmdbclient.data.model.tvshow.TVShow


interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TVShow>
    suspend fun saveTvShowsToDB(tvShows: List<TVShow>)
    suspend fun clearAll()
}