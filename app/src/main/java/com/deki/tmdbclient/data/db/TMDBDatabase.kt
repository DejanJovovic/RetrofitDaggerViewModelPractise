package com.deki.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deki.tmdbclient.data.model.artist.Artist
import com.deki.tmdbclient.data.model.movie.Movie
import com.deki.tmdbclient.data.model.tvshow.TVShow

@Database(
    entities = [Movie::class, TVShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDAO
    abstract fun tvShowDao(): TvShowDAO
    abstract fun artistDao(): ArtistDAO
}