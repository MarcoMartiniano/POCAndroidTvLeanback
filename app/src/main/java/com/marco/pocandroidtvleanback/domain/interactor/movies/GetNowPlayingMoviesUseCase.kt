package com.marco.pocandroidtvleanback.domain.interactor.movies

import com.marco.pocandroidtvleanback.domain.core.UseCase
import com.marco.pocandroidtvleanback.domain.model.movies.Movies
import com.marco.pocandroidtvleanback.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetNowPlayingMoviesUseCase(
    scope: CoroutineScope,
    private val repository: MovieRepository,
) : UseCase<Movies, Unit>(scope) {

    override fun run(params: Unit?): Flow<Movies> = repository.getNowPlayingMovies()
}