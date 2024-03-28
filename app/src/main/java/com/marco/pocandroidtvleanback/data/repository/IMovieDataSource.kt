package com.marco.pocandroidtvleanback.data.repository

import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying

interface IMovieDataSource {
    suspend fun getNowPlayingMovies(): NowPlaying
}