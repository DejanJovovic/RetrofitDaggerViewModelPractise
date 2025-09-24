package com.deki.tmdbclient.domain.usecases

import com.deki.tmdbclient.data.model.tvshow.TVShow
import com.deki.tmdbclient.domain.repository.TvShowsRepository

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute(): List<TVShow>? = tvShowsRepository.updateTvShows()
}