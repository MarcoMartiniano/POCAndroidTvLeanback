package com.marco.pocandroidtvleanback.data.repository

import com.marco.pocandroidtvleanback.domain.model.movies.Movies

interface IMovieDataSource {
    suspend fun getNowPlayingMovies(): Movies
    suspend fun getPopularMovies(): Movies
    suspend fun getTopRatedMovies(): Movies
    suspend fun getUpcomingMovies(): Movies
}