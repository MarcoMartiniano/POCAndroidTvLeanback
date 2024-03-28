package com.marco.pocandroidtvleanback.data_remote.datasource

import com.marco.pocandroidtvleanback.data.repository.IMovieDataSource
import com.marco.pocandroidtvleanback.data_remote.mappers.toNowPlaying
import com.marco.pocandroidtvleanback.data_remote.mappers.toPopular
import com.marco.pocandroidtvleanback.data_remote.mappers.toTopRated
import com.marco.pocandroidtvleanback.data_remote.mappers.toUpcoming
import com.marco.pocandroidtvleanback.data_remote.service.MovieService
import com.marco.pocandroidtvleanback.data_remote.utils.requestWrapper
import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying
import com.marco.pocandroidtvleanback.domain.model.movies.Popular
import com.marco.pocandroidtvleanback.domain.model.movies.TopRated
import com.marco.pocandroidtvleanback.domain.model.movies.Upcoming

class MovieDataSourceImpl(
    private val service: MovieService,
) : IMovieDataSource {
    override suspend fun getNowPlayingMovies(): NowPlaying = requestWrapper {
        service.getNowPlayingMovies()
    }.toNowPlaying()

    override suspend fun getPopularMovies(): Popular = requestWrapper {
        service.getPopularMovies()
    }.toPopular()

    override suspend fun getTopRatedMovies(): TopRated = requestWrapper {
        service.getTopRatedMovies()
    }.toTopRated()

    override suspend fun getUpcomingMovies(): Upcoming = requestWrapper {
        service.getUpcomingMovies()
    }.toUpcoming()

}