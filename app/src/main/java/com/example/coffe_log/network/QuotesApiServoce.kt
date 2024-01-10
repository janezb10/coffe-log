package com.example.coffe_log.network

import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.Retrofit

private const val BASE_URL =
    "https://type.fit/api/quotes"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface QuotesApiService {
    @GET("quotes")
    suspend fun getQuotes(): String
}

object QuotesApi {
    val retrofitService : QuotesApiService by lazy {
        retrofit.create(QuotesApiService::class.java)
    }
}
