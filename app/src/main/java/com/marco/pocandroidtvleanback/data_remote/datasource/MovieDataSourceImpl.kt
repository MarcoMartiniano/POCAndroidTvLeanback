package com.marco.pocandroidtvleanback.data_remote.datasource

import com.marco.pocandroidtvleanback.data.repository.IMovieDataSource
import com.marco.pocandroidtvleanback.data_remote.mappers.toNowPlaying
import com.marco.pocandroidtvleanback.data_remote.service.MovieService
import com.marco.pocandroidtvleanback.data_remote.utils.requestWrapper
import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying

class MovieDataSourceImpl(
    private val service: MovieService,
) : IMovieDataSource {
    override suspend fun getNowPlayingMovies(): NowPlaying = requestWrapper {
        service.getNowPlayingMovies()
    }.toNowPlaying()

}