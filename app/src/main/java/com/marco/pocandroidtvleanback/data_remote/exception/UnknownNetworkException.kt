package com.marco.pocandroidtvleanback.data_remote.exception

class UnknownNetworkException(message: String? = null, title: String? = null) :
    RuntimeException(message, Throwable(title))