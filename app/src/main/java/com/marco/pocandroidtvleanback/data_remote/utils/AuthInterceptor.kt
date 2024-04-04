package com.marco.pocandroidtvleanback.data_remote.utils

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {
    @Synchronized
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder().cacheControl(CacheControl.FORCE_NETWORK)

        addingHeaders(request)

        return chain.proceed(request.build())
    }

    @Synchronized
    fun addingHeaders(builder: Request.Builder) {
        builder.header("accept", "application/json")
        builder.header("Authorization", ServiceConstants.API_KEY)
    }
}