package com.marco.pocandroidtvleanback.domain.interactor.movies

import com.marco.pocandroidtvleanback.domain.core.UseCase
import com.marco.pocandroidtvleanback.domain.model.movies.TopRated
import com.marco.pocandroidtvleanback.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetTopRatedMoviesUseCase(
    scope: CoroutineScope,
    private val repository: MovieRepository,
) : UseCase<TopRated, Unit>(scope) {

    override fun run(params: Unit?): Flow<TopRated> = repository.getTopRatedMovies()
}