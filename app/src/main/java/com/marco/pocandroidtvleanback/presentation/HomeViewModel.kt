package com.marco.pocandroidtvleanback.presentation

import androidx.lifecycle.ViewModel
import com.marco.pocandroidtvleanback.domain.interactor.movies.GetNowPlayingMoviesUseCase
import com.marco.pocandroidtvleanback.domain.model.movies.NowPlaying
import com.marco.pocandroidtvleanback.utils.asLiveData
import com.marco.pocandroidtvleanback.utils.postError
import com.marco.pocandroidtvleanback.utils.postNeutral
import com.marco.pocandroidtvleanback.utils.postSuccess
import com.marco.pocandroidtvleanback.utils.useCase
import com.marco.pocandroidtvleanback.utils.viewState
import org.koin.core.component.KoinComponent

class HomeViewModel : ViewModel(), KoinComponent {

    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase by useCase()

    private val _getNowPlayingMoviesViewState by viewState<NowPlaying>()
    val getNowPlayingMoviesViewState = _getNowPlayingMoviesViewState.asLiveData()

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

    fun clearViewStates() {
        _getNowPlayingMoviesViewState.postNeutral()
    }
}