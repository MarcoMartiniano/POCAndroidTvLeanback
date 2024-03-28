package com.marco.pocandroidtvleanback.data_remote.mappers

import com.marco.pocandroidtvleanback.data_remote.model.DatesResponse
import com.marco.pocandroidtvleanback.data_remote.model.NowPlayingResponse
import com.marco.pocandroidtvleanback.data_remote.model.ResultResponse
import com.marco.pocandroidtvleanback.domain.model.movies.Dates
import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying
import com.marco.pocandroidtvleanback.domain.model.movies.Result

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