package com.deki.tmdbclient.data.model.tvshow

import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val tVShows: List<TVShow>,
)