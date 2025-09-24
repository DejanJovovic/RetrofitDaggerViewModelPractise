package com.deki.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deki.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistDAO {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(): List<Artist>
}