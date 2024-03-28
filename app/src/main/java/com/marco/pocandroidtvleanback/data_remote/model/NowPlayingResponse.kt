package com.marco.pocandroidtvleanback.data_remote.model

import com.google.gson.annotations.SerializedName

data class NowPlayingResponse(
    @SerializedName("dates") val dates: DatesResponse? = null,
    @SerializedName("page") val page: Int? = null,
    @SerializedName("results") val results: List<ResultResponse>? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
)