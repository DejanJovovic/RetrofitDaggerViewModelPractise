package com.deki.tmdbclient.domain.repository

import com.deki.tmdbclient.data.model.tvshow.TVShow

interface TvShowsRepository {

    suspend fun getTvShows(): List<TVShow>?
    suspend fun updateTvShows(): List<TVShow>?
}