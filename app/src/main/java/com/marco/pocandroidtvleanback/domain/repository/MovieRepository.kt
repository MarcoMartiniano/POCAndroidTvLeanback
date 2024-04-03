package com.marco.pocandroidtvleanback.domain.repository

import com.marco.pocandroidtvleanback.domain.model.movies.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getNowPlayingMovies(): Flow<Movies>
    fun getPopularMovies(): Flow<Movies>
    fun getTopRatedMovies(): Flow<Movies>
    fun getUpcomingMovies(): Flow<Movies>
}