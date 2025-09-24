package com.deki.tmdbclient.data.repository.movie.datasource

import com.deki.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {

    suspend fun getMovies(): Response<MovieList>
}