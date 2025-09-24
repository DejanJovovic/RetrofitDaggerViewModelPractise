package com.deki.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deki.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.deki.tmdbclient.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }

}