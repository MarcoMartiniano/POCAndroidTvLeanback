package com.marco.pocandroidtvleanback.data_remote.model

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("status_code") val statusCode: Int? = null,
    @SerializedName("status_message") val statusMessage: String? = null,
    @SerializedName("success") val isSuccess: Boolean? = null,
)