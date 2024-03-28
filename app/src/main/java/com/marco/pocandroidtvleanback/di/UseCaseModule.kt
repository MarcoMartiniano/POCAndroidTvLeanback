package com.marco.pocandroidtvleanback.di


import com.marco.pocandroidtvleanback.domain.core.ThreadContextProvider
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetNowPlayingMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        ThreadContextProvider()
    }

    // movies
    factory { GetNowPlayingMoviesUseCase(get(), get()) }

}