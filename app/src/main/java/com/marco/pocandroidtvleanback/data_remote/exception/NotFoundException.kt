package com.marco.pocandroidtvleanback.data_remote.exception

class NotFoundException(message: String? = null, title: String? = null) :
    RuntimeException(message, Throwable(title))