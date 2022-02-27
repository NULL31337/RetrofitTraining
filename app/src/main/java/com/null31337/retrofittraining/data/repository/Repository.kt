package com.null31337.retrofittraining.data.repository

import com.null31337.retrofittraining.data.api.RetrofitInstance
import com.null31337.retrofittraining.model.money.Money
import retrofit2.Response

class Repository {
    suspend fun getMoney() : Response<Money> {
        return RetrofitInstance.api.getMoney()
    }

}