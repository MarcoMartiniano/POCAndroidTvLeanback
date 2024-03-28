package com.marco.pocandroidtvleanback.data_remote.exception

class UnauthorizedException(message: String? = null, title: String? = null) :
    RuntimeException(message, Throwable(title))