package com.marco.pocandroidtvleanback.data.datasource

import com.marco.pocandroidtvleanback.data.repository.IMovieDataSource
import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying
import com.marco.pocandroidtvleanback.domain.model.movies.Popular
import com.marco.pocandroidtvleanback.domain.model.movies.TopRated
import com.marco.pocandroidtvleanback.domain.model.movies.Upcoming
import com.marco.pocandroidtvleanback.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val iMovieDataSource: IMovieDataSource,
) : MovieRepository {
    override fun getNowPlayingMovies(): Flow<NowPlaying> = flow {
        emit(iMovieDataSource.getNowPlayingMovies())
    }

    override fun getPopularMovies(): Flow<Popular> = flow {
        emit(iMovieDataSource.getPopularMovies())
    }

    override fun getTopRatedMovies(): Flow<TopRated> = flow {
        emit(iMovieDataSource.getTopRatedMovies())
    }

    override fun getUpcomingMovies(): Flow<Upcoming> = flow {
        emit(iMovieDataSource.getUpcomingMovies())
    }
}