package com.null31337.retrofittraining.data.api.functions

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.null31337.retrofittraining.FUNCTIONS_URL
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


object RetrofitInstance {
    private val json = Json {
        ignoreUnknownKeys = true
    }

     val client by lazy {
        OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    }

    @OptIn(ExperimentalSerializationApi::class)
    val retrofit: Retrofit by lazy {
        var baseUrlFull = FUNCTIONS_URL.ifEmpty { "https://jsonplaceholder.typicode.com/" }
        if (baseUrlFull.last() != '/') {
            baseUrlFull += '/'
        }
        Retrofit.Builder().baseUrl(baseUrlFull).client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType())).build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}