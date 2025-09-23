package com.deki.tmdbclient.data.api

import com.deki.tmdbclient.data.model.artist.ArtistList
import com.deki.tmdbclient.data.model.movie.MovieList
import com.deki.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apikey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apikey: String): Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key") apikey: String): Response<ArtistList>

}