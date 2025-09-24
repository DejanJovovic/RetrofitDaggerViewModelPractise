package com.deki.tmdbclient.data.repository.tvshow.datasourceImpl

import android.util.Log
import com.deki.tmdbclient.data.model.tvshow.TVShow
import com.deki.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.deki.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.deki.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.deki.tmdbclient.domain.repository.TvShowsRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowsRepository {
    override suspend fun getTvShows(): List<TVShow>? {
        //if cached data is available, the system will return it if not it takes it from db, if not it downloads it from tmdb api
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TVShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        //save this new list to cache also
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TVShow> {
        lateinit var tvShowsList: List<TVShow>

        //get data from api
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowsList = body.tVShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromDB(): List<TVShow> {
        lateinit var tvShowsList: List<TVShow>

        //get data from api
        try {
            tvShowsList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowsList.size > 0) {
            return tvShowsList
        }
        //take from rest api and save to db
        else {
            tvShowsList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowsList)

        }

        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TVShow> {
        lateinit var tvShowsList: List<TVShow>

        //get data from api
        try {
            tvShowsList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowsList.size > 0) {
            return tvShowsList
        }
        //take from rest api and save to db
        else {
            tvShowsList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        }

        return tvShowsList
    }
}