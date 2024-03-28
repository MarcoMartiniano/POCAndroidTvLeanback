package com.marco.pocandroidtvleanback.data_remote.model

import com.google.gson.annotations.SerializedName
import com.marco.pocandroidtvleanback.domain.model.movies.Result

data class PopularResponse(
    @SerializedName("page") val page: Int? = null,
    @SerializedName("results") val results: List<Result>? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
)