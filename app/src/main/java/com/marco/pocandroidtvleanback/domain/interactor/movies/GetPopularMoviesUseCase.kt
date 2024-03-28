package com.marco.pocandroidtvleanback.domain.interactor.movies

import com.marco.pocandroidtvleanback.domain.core.UseCase
import com.marco.pocandroidtvleanback.domain.model.movies.Popular
import com.marco.pocandroidtvleanback.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetPopularMoviesUseCase(
    scope: CoroutineScope,
    private val repository: MovieRepository,
) : UseCase<Popular, Unit>(scope) {

    override fun run(params: Unit?): Flow<Popular> = repository.getPopularMovies()
}