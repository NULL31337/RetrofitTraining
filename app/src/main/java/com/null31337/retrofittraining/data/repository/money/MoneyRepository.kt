package com.null31337.retrofittraining.data.repository.money

import com.null31337.retrofittraining.data.api.money.RetrofitInstance
import com.null31337.retrofittraining.model.money.Money
import retrofit2.Response

class MoneyRepository {
    suspend fun getMoney(): Response<Money> {
        return RetrofitInstance.api.getMoney()
    }

}