package com.marco.pocandroidtvleanback.di

import com.marco.pocandroidtvleanback.data.repository.IMovieDataSource
import com.marco.pocandroidtvleanback.data_remote.datasource.MovieDataSourceImpl
import com.marco.pocandroidtvleanback.data_remote.service.MovieService
import com.marco.pocandroidtvleanback.data_remote.utils.WebServiceFactory
import org.koin.dsl.module

val dataRemoteModule = module {
    single<IMovieDataSource> { MovieDataSourceImpl(get()) }

    single {
        WebServiceFactory.provideOkHttpClient(
            true,
        )
    }

    single<MovieService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = "https://api.themoviedb.org/3/"
        )
    }
}