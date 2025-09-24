package com.deki.tmdbclient.domain.usecases

import com.deki.tmdbclient.data.model.movie.Movie
import com.deki.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}