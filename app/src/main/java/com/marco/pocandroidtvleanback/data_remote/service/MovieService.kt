package com.marco.pocandroidtvleanback.data_remote.service

import com.marco.pocandroidtvleanback.data_remote.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): Response<MoviesResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MoviesResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): Response<MoviesResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): Response<MoviesResponse>
}