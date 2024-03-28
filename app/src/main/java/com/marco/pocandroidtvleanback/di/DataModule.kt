package com.marco.pocandroidtvleanback.di

import com.marco.pocandroidtvleanback.data.datasource.MovieRepositoryImpl
import com.marco.pocandroidtvleanback.domain.repository.MovieRepository
import org.koin.dsl.module

val dataModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}