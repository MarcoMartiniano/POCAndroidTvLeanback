package com.marco.pocandroidtvleanback.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.marco.pocandroidtvleanback.utils.ViewState.Status.ERROR
import com.marco.pocandroidtvleanback.utils.ViewState.Status.LOADING
import com.marco.pocandroidtvleanback.utils.ViewState.Status.SUCCESS

fun <T> viewState() = lazy {
    MutableLiveData<ViewState<T>>()
}

fun <T> MutableLiveData<ViewState<T>>.postNeutral() {
    value = ViewState(ViewState.Status.NEUTRAL, null, null)
}

fun <T> MutableLiveData<ViewState<T>>.setSuccess(data: T) {
    value = ViewState(SUCCESS, data, null)
}

fun <T> MutableLiveData<ViewState<T>>.setError(error: Throwable?) {
    value = ViewState(ERROR, null, error)
}

fun <T> MutableLiveData<ViewState<T>>.setError(message: String?) {
    value = ViewState(ERROR, null, RuntimeException(message))
}

fun <T> MutableLiveData<ViewState<T>>.postSuccess(data: T) {
    postValue(ViewState(SUCCESS, data, null))
}

fun <T> MutableLiveData<ViewState<T>>.postError(error: Throwable?) {
    postValue(ViewState(ERROR, null, error))
}

fun <T> MutableLiveData<ViewState<T>>.postError(message: String?) {
    postValue(ViewState(ERROR, null, RuntimeException(message)))
}

fun <T> MutableLiveData<ViewState<T>>.postLoading() {
    postValue(ViewState(LOADING, null, null))
}

fun <T> MutableLiveData<ViewState<T>>.setLoading() {
    value = ViewState(LOADING, null, null)
}

fun <T> MutableLiveData<T>.asLiveData(): LiveData<T> = this

fun <T> LiveData<ViewState<T>>.isLoading() = value.isLoading()

fun <T> LiveData<ViewState<T>>.isSuccess() = value.isSuccess()

fun <T> LiveData<ViewState<T>>.isError() = value.isError()

fun <T> LiveData<ViewState<T>>.isNeutral() = value.isNeutral()

fun <T> LiveData<ViewState<T>>.observeLiveData(
    lifecycleOwner: LifecycleOwner,
    isSingleEvent: Boolean = false,
    event: (ViewState<T>) -> Unit,
) {
    observe(
        lifecycleOwner,
        Observer {
            (this as? EventLiveData)?.apply {
                getContent(isSingleEvent)?.let { event(it) }
                return@Observer
            }
            value?.let { event(it) }
        }
    )
}
