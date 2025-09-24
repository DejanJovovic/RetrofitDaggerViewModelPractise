package com.deki.tmdbclient.data.repository.tvshow.datasourceImpl

import com.deki.tmdbclient.data.model.tvshow.TVShow
import com.deki.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = ArrayList<TVShow>()
    override suspend fun getTvShowsFromCache(): List<TVShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}