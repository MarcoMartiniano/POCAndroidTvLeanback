package com.marco.pocandroidtvleanback.data.datasource

import com.marco.pocandroidtvleanback.data.repository.IMovieDataSource
import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying
import com.marco.pocandroidtvleanback.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val iMovieDataSource: IMovieDataSource,
) : MovieRepository {
    override fun getNowPlayingMovies(): Flow<NowPlaying> = flow {
        emit(iMovieDataSource.getNowPlayingMovies())
    }
}