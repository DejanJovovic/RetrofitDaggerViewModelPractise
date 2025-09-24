package com.deki.tmdbclient.data.repository.artist.datasourceImpl

import android.util.Log
import com.deki.tmdbclient.data.model.artist.Artist
import com.deki.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.deki.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.deki.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.deki.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        //if cached data is available, the system will return it if not it takes it from db, if not it downloads it from tmdb api
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        //save this new list to cache also
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistsList: List<Artist>

        //get data from api
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistsList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return artistsList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        //get data from api
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        }
        //take from rest api and save to db
        else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)

        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        //get data from api
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        }
        //take from rest api and save to db
        else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}