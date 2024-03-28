package com.marco.pocandroidtvleanback.presentation

import androidx.lifecycle.ViewModel
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetNowPlayingMoviesUseCase
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetPopularMoviesUseCase
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetTopRatedMoviesUseCase
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetUpcomingMoviesUseCase
import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying
import com.marco.pocandroidtvleanback.domain.model.movies.Popular
import com.marco.pocandroidtvleanback.domain.model.movies.TopRated
import com.marco.pocandroidtvleanback.domain.model.movies.Upcoming
import com.marco.pocandroidtvleanback.utils.asLiveData
import com.marco.pocandroidtvleanback.utils.postError
import com.marco.pocandroidtvleanback.utils.postNeutral
import com.marco.pocandroidtvleanback.utils.postSuccess
import com.marco.pocandroidtvleanback.utils.useCase
import com.marco.pocandroidtvleanback.utils.viewState
import org.koin.core.component.KoinComponent

class HomeViewModel : ViewModel(), KoinComponent {

    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase by useCase()
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase by useCase()
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase by useCase()
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase by useCase()

    private val _getNowPlayingMoviesViewState by viewState<NowPlaying>()
    val getNowPlayingMoviesViewState = _getNowPlayingMoviesViewState.asLiveData()

    private val _getPopularMoviesViewState by viewState<Popular>()
    val getPopularMoviesViewState = _getPopularMoviesViewState.asLiveData()

    private val _getTopRatedMoviesViewState by viewState<TopRated>()
    val getTopRatedMoviesViewState = _getTopRatedMoviesViewState.asLiveData()

    private val _getUpcomingMoviesViewState by viewState<Upcoming>()
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