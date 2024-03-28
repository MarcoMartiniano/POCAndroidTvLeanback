package com.marco.pocandroidtvleanback.domain.repository

import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying
import com.marco.pocandroidtvleanback.domain.model.movies.Popular
import com.marco.pocandroidtvleanback.domain.model.movies.TopRated
import com.marco.pocandroidtvleanback.domain.model.movies.Upcoming
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getNowPlayingMovies(): Flow<NowPlaying>
    fun getPopularMovies(): Flow<Popular>
    fun getTopRatedMovies(): Flow<TopRated>
    fun getUpcomingMovies(): Flow<Upcoming>
}