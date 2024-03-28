package com.marco.pocandroidtvleanback.data.repository

import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying
import com.marco.pocandroidtvleanback.domain.model.movies.Popular
import com.marco.pocandroidtvleanback.domain.model.movies.TopRated
import com.marco.pocandroidtvleanback.domain.model.movies.Upcoming

interface IMovieDataSource {
    suspend fun getNowPlayingMovies(): NowPlaying
    suspend fun getPopularMovies(): Popular
    suspend fun getTopRatedMovies(): TopRated
    suspend fun getUpcomingMovies(): Upcoming
}