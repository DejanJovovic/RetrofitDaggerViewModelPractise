package com.deki.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deki.tmdbclient.data.model.tvshow.TVShow

@Dao
interface TvShowDAO {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun saveTvShows(tvShows: List<TVShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTvShows(): List<TVShow>
}