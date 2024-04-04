package com.marco.pocandroidtvleanback.presentation

import androidx.lifecycle.ViewModel
import com.marco.pocandroidtvleanback.core.commons.extensions.asLiveData
import com.marco.pocandroidtvleanback.core.commons.extensions.postError
import com.marco.pocandroidtvleanback.core.commons.extensions.postNeutral
import com.marco.pocandroidtvleanback.core.commons.extensions.postSuccess
import com.marco.pocandroidtvleanback.core.commons.extensions.useCase
import com.marco.pocandroidtvleanback.core.commons.extensions.viewState
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetNowPlayingMoviesUseCase
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetPopularMoviesUseCase
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetTopRatedMoviesUseCase
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetUpcomingMoviesUseCase
import com.marco.pocandroidtvleanback.domain.model.movies.Movies
import org.koin.core.component.KoinComponent

class HomeViewModel : ViewModel(), KoinComponent {

    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase by useCase()
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase by useCase()
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase by useCase()
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase by useCase()

    private val _getNowPlayingMoviesViewState by viewState<Movies>()
    val getNowPlayingMoviesViewState = _getNowPlayingMoviesViewState.asLiveData()

    private val _getPopularMoviesViewState by viewState<Movies>()
    val getPopularMoviesViewState = _getPopularMoviesViewState.asLiveData()

    private val _getTopRatedMoviesViewState by viewState<Movies>()
    val getTopRatedMoviesViewState = _getTopRatedMoviesViewState.asLiveData()

    private val _getUpcomingMoviesViewState by viewState<Movies>()
    val getUpcomingMoviesViewState = _getUpcomingMoviesViewState.asLiveData()

    fun getNowPlayingMovies() {
        getNowPlayingMoviesUseCase(
            params = Unit,
            onSuccess = {
                _getNowPlayingMoviesViewState.postSuccess(it)
            },
            onError = {
                _getNowPlayingMoviesViewState.postError(it)
            }
        )
    }

    fun getPopularMovies() {
        getPopularMoviesUseCase(
            params = Unit,
            onSuccess = {
                _getPopularMoviesViewState.postSuccess(it)
            },
            onError = {
                _getPopularMoviesViewState.postError(it)
            }
        )
    }

    fun getTopRatedMovies() {
        getTopRatedMoviesUseCase(
            params = Unit,
            onSuccess = {
                _getTopRatedMoviesViewState.postSuccess(it)
            },
            onError = {
                _getTopRatedMoviesViewState.postError(it)
            }
        )
    }

    fun getUpcomingMovies() {
        getUpcomingMoviesUseCase(
            params = Unit,
            onSuccess = {
                _getUpcomingMoviesViewState.postSuccess(it)
            },
            onError = {
                _getUpcomingMoviesViewState.postError(it)
            }
        )
    }

    fun clearViewStates() {
        _getNowPlayingMoviesViewState.postNeutral()
        _getPopularMoviesViewState.postNeutral()
        _getTopRatedMoviesViewState.postNeutral()
        _getUpcomingMoviesViewState.postNeutral()
    }
}