package com.null31337.retrofittraining.model.money

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Money(
    @SerialName("Valute")
    val list: MoneyValue
) {
    fun toList(): MutableList<MoneyItem> {
        val mutableList = mutableListOf<MoneyItem>()
        mutableList.add(list.AUD)
        mutableList.add(list.AZN)
        mutableList.add(list.GBP)
        mutableList.add(list.AMD)
        mutableList.add(list.BYN)
        mutableList.add(list.BGN)
        mutableList.add(list.BRL)
        mutableList.add(list.HUF)
        mutableList.add(list.HKD)
        mutableList.add(list.USD)
        mutableList.add(list.EUR)
        mutableList.add(list.INR)
        mutableList.add(list.KZT)
        mutableList.add(list.CAD)
        mutableList.add(list.KGS)
        mutableList.add(list.CNY)
        mutableList.add(list.NOK)
        mutableList.add(list.PLN)
        mutableList.add(list.RON)
        mutableList.add(list.XDR)
        mutableList.add(list.SGD)
        mutableList.add(list.TJS)
        mutableList.add(list.TRY)
        mutableList.add(list.TMT)
        mutableList.add(list.UZS)
        mutableList.add(list.UAH)
        mutableList.add(list.CZK)
        mutableList.add(list.SEK)
        mutableList.add(list.CHF)
        mutableList.add(list.ZAR)
        mutableList.add(list.KRW)
        mutableList.add(list.JPY)
        return mutableList
    }
}
