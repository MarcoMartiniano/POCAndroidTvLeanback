package com.marco.pocandroidtvleanback.domain.model.movies

data class Upcoming(
    val dates: Dates?,
    val page: Int?,
    val results: List<Result>?,
    val totalPages: Int?,
    val totalResults: Int?,
)