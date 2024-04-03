package com.marco.pocandroidtvleanback.data_remote.datasource

import com.marco.pocandroidtvleanback.data.repository.IMovieDataSource
import com.marco.pocandroidtvleanback.data_remote.service.MovieService
import com.marco.pocandroidtvleanback.data_remote.utils.requestWrapper
import com.marco.pocandroidtvleanback.domain.model.movies.Movies
import com.marco.pocandroidtvleanback.data_remote.mappers.toMovies

class MovieDataSourceImpl(
    private val service: MovieService,
) : IMovieDataSource {
    override suspend fun getNowPlayingMovies(): Movies = requestWrapper {
        service.getNowPlayingMovies()
    }.toMovies()

    override suspend fun getPopularMovies(): Movies = requestWrapper {
        service.getPopularMovies()
    }.toMovies()

    override suspend fun getTopRatedMovies(): Movies = requestWrapper {
        service.getTopRatedMovies()
    }.toMovies()

    override suspend fun getUpcomingMovies(): Movies = requestWrapper {
        service.getUpcomingMovies()
    }.toMovies()

}