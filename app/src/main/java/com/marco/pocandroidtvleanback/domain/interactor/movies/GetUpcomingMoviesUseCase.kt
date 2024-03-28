package com.marco.pocandroidtvleanback.domain.interactor.movies

import com.marco.pocandroidtvleanback.domain.core.UseCase
import com.marco.pocandroidtvleanback.domain.model.movies.Upcoming
import com.marco.pocandroidtvleanback.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetUpcomingMoviesUseCase(
    scope: CoroutineScope,
    private val repository: MovieRepository,
) : UseCase<Upcoming, Unit>(scope) {

    override fun run(params: Unit?): Flow<Upcoming> = repository.getUpcomingMovies()
}