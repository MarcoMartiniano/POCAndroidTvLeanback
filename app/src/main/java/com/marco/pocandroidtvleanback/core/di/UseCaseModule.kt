package com.marco.pocandroidtvleanback.core.di


import com.marco.pocandroidtvleanback.domain.core.ThreadContextProvider
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetNowPlayingMoviesUseCase
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetPopularMoviesUseCase
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetTopRatedMoviesUseCase
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetUpcomingMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        ThreadContextProvider()
    }

    // movies
    factory { GetNowPlayingMoviesUseCase(get(), get()) }
    factory { GetPopularMoviesUseCase(get(), get()) }
    factory { GetTopRatedMoviesUseCase(get(), get()) }
    factory { GetUpcomingMoviesUseCase(get(), get()) }
}