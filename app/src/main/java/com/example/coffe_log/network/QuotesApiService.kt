package com.example.coffe_log.network

//import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
//import kotlinx.serialization.json.Json
//import okhttp3.MediaType
//import okhttp3.MediaType.Companion.toMediaType
//import retrofit2.Retrofit
//import retrofit2.http.GET

import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.*
import kotlinx.serialization.*
import okhttp3.MediaType.Companion.toMediaType


private const val BASE_URL =
    "https://type.fit/api/"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface QuotesApiService {
    @GET("quotes")
    suspend fun getQuotes(): List<Quote>

}

object QuotesApi {
    val retrofitService : QuotesApiService by lazy {
        retrofit.create(QuotesApiService::class.java)
    }

}

