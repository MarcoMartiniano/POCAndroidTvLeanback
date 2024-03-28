package com.marco.pocandroidtvleanback.data_remote.exception

import java.io.IOException

class InvalidApiKeyException(
    message: String? = null,
    title: String? = null,
) : IOException(message, Throwable(title))