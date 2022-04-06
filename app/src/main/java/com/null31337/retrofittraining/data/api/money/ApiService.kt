package com.null31337.retrofittraining.data.api.money

import com.null31337.retrofittraining.model.money.Money
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("daily_json.js")
    suspend fun getMoney(): Response<Money>
}