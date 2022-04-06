package com.null31337.retrofittraining.screens.money

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.null31337.retrofittraining.data.repository.money.MoneyRepository
import com.null31337.retrofittraining.model.money.Money
import kotlinx.coroutines.launch
import retrofit2.Response

class MoneyViewModel : ViewModel() {
    private var rep = MoneyRepository()
    var moneyList: MutableLiveData<Response<Money>> = MutableLiveData()

    fun getMoney() {
        viewModelScope.launch {
            var tmp = rep.getMoney()
            while (!tmp.isSuccessful) {
                tmp = rep.getMoney()
            }
            moneyList.value = tmp
        }
    }
}