package com.example.coffe_log.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Quote(
    @SerialName(value="text")
    val tekst: String,
    val author: String
)