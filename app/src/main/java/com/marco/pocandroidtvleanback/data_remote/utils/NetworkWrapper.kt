package com.marco.pocandroidtvleanback.data_remote.utils

import com.google.gson.Gson
import com.marco.pocandroidtvleanback.data_remote.exception.InvalidApiKeyException
import com.marco.pocandroidtvleanback.data_remote.exception.NotFoundException
import com.marco.pocandroidtvleanback.data_remote.exception.UnauthorizedException
import com.marco.pocandroidtvleanback.data_remote.exception.UnknownNetworkException
import com.marco.pocandroidtvleanback.data_remote.model.ErrorResponse
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response

suspend fun <D> requestWrapper(
    noContent: Boolean = false,
    call: suspend () -> Response<D>,
): D {
    call().let { result ->
        return when {
            result.isSuccessful.not() -> throw handleExceptionByCode(result)
            noContent -> Unit as D
            else -> result.body() ?: throw NoContentException()
        }
    }
}

@Suppress("MagicNumber", "ThrowsCount")
private fun handleExceptionByCode(response: Response<*>): Exception {
    when (response.code()) {
        400 -> throw UnauthorizedException(message = response.errorBody()?.string())
        401 -> {
            val error = response.errorBody()?.getErrorObject<ErrorResponse>()
            when (error?.statusCode) {
                7 -> {
                    throw InvalidApiKeyException(message = error.statusCode.toString())
                }

                else -> {
                    throw UnknownNetworkException()
                }
            }
        }

        404 -> throw NotFoundException()
        else -> throw UnknownNetworkException()
    }
}

inline fun <reified T> ResponseBody.getErrorObject(): T {
    val gson = Gson()
    val jsonObject = JSONObject(charStream().readText())
    return gson.fromJson(jsonObject.toString(), T::class.java)
}