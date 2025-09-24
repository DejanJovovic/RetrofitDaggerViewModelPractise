package com.deki.tmdbclient.data.repository.tvshow.datasource

import com.deki.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TVShowList>

}