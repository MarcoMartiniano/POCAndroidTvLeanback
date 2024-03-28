package com.marco.pocandroidtvleanback.data_remote.mappers

import com.marco.pocandroidtvleanback.data_remote.model.DatesResponse
import com.marco.pocandroidtvleanback.data_remote.model.NowPlayingResponse
import com.marco.pocandroidtvleanback.data_remote.model.PopularResponse
import com.marco.pocandroidtvleanback.data_remote.model.ResultResponse
import com.marco.pocandroidtvleanback.data_remote.model.TopRatedResponse
import com.marco.pocandroidtvleanback.data_remote.model.UpcomingResponse
import com.marco.pocandroidtvleanback.domain.model.movies.Dates
import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying
import com.marco.pocandroidtvleanback.domain.model.movies.Popular
import com.marco.pocandroidtvleanback.domain.model.movies.Result
import com.marco.pocandroidtvleanback.domain.model.movies.TopRated
import com.marco.pocandroidtvleanback.domain.model.movies.Upcoming

fun NowPlayingResponse.toNowPlaying() = NowPlaying(
    dates = dates?.toDates(),
    page = page,
    results = results?.map { it.toResult() },
    totalPages = totalPages,
    totalResults = totalResults
)

fun DatesResponse.toDates() = Dates(
    maximum = maximum,
    minimum = minimum
)

fun ResultResponse.toResult() = Result(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun PopularResponse.toPopular() = Popular(
    page = page,
    results = results,
    totalPages = totalPages,
    totalResults = totalResults
)

fun TopRatedResponse.toTopRated() = TopRated(
    page = page,
    results = results?.map { it.toResult() },
    totalPages = totalPages,
    totalResults = totalResults
)

fun UpcomingResponse.toUpcoming() = Upcoming(
    dates = dates?.toDates(),
    page = page,
    results = results?.map { it.toResult() },
    totalPages = totalPages,
    totalResults = totalResults
)