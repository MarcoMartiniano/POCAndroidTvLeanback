package com.marco.pocandroidtvleanback.data_remote.service

import com.marco.pocandroidtvleanback.data_remote.model.NowPlayingResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(): Response<NowPlayingResponse>
}