package com.marco.pocandroidtvleanback.data.datasource

import com.marco.pocandroidtvleanback.data.repository.IMovieDataSource
import com.marco.pocandroidtvleanback.domain.model.movies.Movies
import com.marco.pocandroidtvleanback.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val iMovieDataSource: IMovieDataSource,
) : MovieRepository {
    override fun getNowPlayingMovies(): Flow<Movies> = flow {
        emit(iMovieDataSource.getNowPlayingMovies())
    }

    override fun getPopularMovies(): Flow<Movies> = flow {
        emit(iMovieDataSource.getPopularMovies())
    }

    override fun getTopRatedMovies(): Flow<Movies> = flow {
        emit(iMovieDataSource.getTopRatedMovies())
    }

    override fun getUpcomingMovies(): Flow<Movies> = flow {
        emit(iMovieDataSource.getUpcomingMovies())
    }
}