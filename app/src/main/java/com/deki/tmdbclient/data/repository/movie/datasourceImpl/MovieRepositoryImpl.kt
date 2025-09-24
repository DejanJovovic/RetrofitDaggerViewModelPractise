package com.deki.tmdbclient.data.repository.movie.datasourceImpl

import android.util.Log
import com.deki.tmdbclient.data.model.movie.Movie
import com.deki.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.deki.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.deki.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.deki.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDataSource,
    private val movieCacheDatasource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        //if cached data is available, the system will return it if not it takes it from db, if not it downloads it from tmdb api
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        //save this new list to cache also
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        //get data from api
        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        //get data from api
        try {
            movieList = movieLocalDatasource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        }
        //take from rest api and save to db
        else {
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)

        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        //get data from api
        try {
            movieList = movieCacheDatasource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        }
        //take from rest api and save to db
        else {
            movieList = getMoviesFromDB()
            movieCacheDatasource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}