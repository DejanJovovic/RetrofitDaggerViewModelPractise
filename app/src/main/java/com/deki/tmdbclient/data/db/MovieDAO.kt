package com.deki.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deki.tmdbclient.data.model.movie.Movie

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(movies: List<Movie>)
}