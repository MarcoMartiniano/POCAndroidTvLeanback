package com.marco.pocandroidtvleanback.data_remote.service

import com.marco.pocandroidtvleanback.data_remote.model.NowPlayingResponse
import com.marco.pocandroidtvleanback.data_remote.model.PopularResponse
import com.marco.pocandroidtvleanback.data_remote.model.TopRatedResponse
import com.marco.pocandroidtvleanback.data_remote.model.UpcomingResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): Response<NowPlayingResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<PopularResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): Response<TopRatedResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): Response<UpcomingResponse>
}