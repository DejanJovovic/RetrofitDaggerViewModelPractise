package com.deki.tmdbclient.data


import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val tVShows: List<TVShow>,
)