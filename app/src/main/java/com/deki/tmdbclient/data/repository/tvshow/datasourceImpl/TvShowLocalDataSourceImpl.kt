package com.deki.tmdbclient.data.repository.tvshow.datasourceImpl

import com.deki.tmdbclient.data.db.ArtistDAO
import com.deki.tmdbclient.data.db.TvShowDAO
import com.deki.tmdbclient.data.model.artist.Artist
import com.deki.tmdbclient.data.model.tvshow.TVShow
import com.deki.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.deki.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(
    private val tvShowDAO: TvShowDAO
) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TVShow> {
        return tvShowDAO.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTvShows()
        }
    }
}