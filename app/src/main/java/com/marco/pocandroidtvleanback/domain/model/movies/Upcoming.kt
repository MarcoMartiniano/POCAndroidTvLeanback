package com.marco.pocandroidtvleanback.domain.model.movies

data class Upcoming(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int,
)